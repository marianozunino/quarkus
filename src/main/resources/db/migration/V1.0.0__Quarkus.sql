CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE todo
(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    title VARCHAR(20) unique,
    url VARCHAR(20),
    completed boolean,
    ordering integer
);
