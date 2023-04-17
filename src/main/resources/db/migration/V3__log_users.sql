CREATE TABLE users_history (
                            id SERIAL PRIMARY KEY,
                            username VARCHAR(50),
                            action VARCHAR(50),
                            table_name VARCHAR(100),
                            old_data JSONB,
                            new_data JSONB,
                            event_time TIMESTAMP
);

CREATE OR REPLACE FUNCTION users_history()
    RETURNS trigger AS $$
BEGIN
    INSERT INTO users_history (username, action, table_name, new_data, event_time)
    VALUES (current_user, TG_OP, TG_TABLE_NAME, row_to_json(NEW), clock_timestamp());
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER users_history
    AFTER INSERT OR UPDATE OR DELETE ON users
    FOR EACH ROW
EXECUTE FUNCTION users_history();