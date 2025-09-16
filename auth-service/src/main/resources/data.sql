-- Ensure the 'users' table exists
CREATE TABLE IF NOT EXISTS users (
                                     id UUID PRIMARY KEY,
                                     email VARCHAR(255) UNIQUE NOT NULL,
                                     password VARCHAR(255) NOT NULL,
                                     role VARCHAR(50) NOT NULL
);

-- Insert a default admin user if not already present (H2-compatible)
MERGE INTO users u
USING (SELECT
           '223e4567-e89b-12d3-a456-426614174006'::uuid AS id,
           'testuser@test.com' AS email,
           '$2b$12$7hoRZfJrRKD2nIm2vHLs7OBETy.LWenXXMLKf99W8M4PUwO6KB7fu' AS password,
           'ADMIN' AS role
) vals
ON u.email = vals.email
WHEN NOT MATCHED THEN
    INSERT (id, email, password, role)
    VALUES (vals.id, vals.email, vals.password, vals.role);
