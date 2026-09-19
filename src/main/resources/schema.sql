CREATE TABLE IF NOT EXISTS recruitment_detail (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    eligibility VARCHAR(2000),
    roles VARCHAR(2000),
    location VARCHAR(1000),
    internship VARCHAR(500),
    stipend VARCHAR(500),
    ctc VARCHAR(500),
    fixed_compensation VARCHAR(500),
    variable_compensation VARCHAR(500),
    bonus VARCHAR(500),
    service_agreement VARCHAR(1000),
    training_period VARCHAR(500),
    joining VARCHAR(500),
    work_mode VARCHAR(500),
    degree VARCHAR(500),
    education_gap VARCHAR(1000),
    onboarding_locations VARCHAR(1000),
    notes VARCHAR(2000),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS company_role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    name VARCHAR(500),
    eligible_programs VARCHAR(1000),
    eligible_branches VARCHAR(1000),
    hiring_role VARCHAR(1000),
    expectations VARCHAR(2000),
    responsibilities VARCHAR(4000),
    source_type VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS hiring_stage (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    sequence_number INT NOT NULL,
    name VARCHAR(500),
    details VARCHAR(2000),
    source_type VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS registration_link (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    label VARCHAR(500),
    url VARCHAR(1000),
    deadline VARCHAR(500),
    instructions VARCHAR(2000),
    source_type VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS subject (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    source_type VARCHAR(100),
    PRIMARY KEY (id),
    UNIQUE KEY uk_subject_name (name)
);

CREATE TABLE IF NOT EXISTS company_subject (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    priority INT NOT NULL,
    notes VARCHAR(2000),
    source_type VARCHAR(100),
    PRIMARY KEY (id),
    UNIQUE KEY uk_company_subject (company_id, subject_id)
);

CREATE TABLE IF NOT EXISTS topic (
    id BIGINT NOT NULL AUTO_INCREMENT,
    subject_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2000),
    source_type VARCHAR(100),
    PRIMARY KEY (id),
    UNIQUE KEY uk_topic_subject_name (subject_id, name)
);

CREATE TABLE IF NOT EXISTS company_topic (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    priority INT NOT NULL,
    section VARCHAR(255),
    source_type VARCHAR(100),
    PRIMARY KEY (id),
    UNIQUE KEY uk_company_topic (company_id, topic_id)
);

CREATE TABLE IF NOT EXISTS preparation_question (
    id BIGINT NOT NULL AUTO_INCREMENT,
    topic_id BIGINT NOT NULL,
    question_text TEXT NOT NULL,
    answer TEXT,
    explanation TEXT,
    question_type VARCHAR(100),
    difficulty VARCHAR(100),
    source_type VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS company_question (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    question_id BIGINT NOT NULL,
    section VARCHAR(255),
    priority INT NOT NULL,
    source_type VARCHAR(100),
    PRIMARY KEY (id),
    UNIQUE KEY uk_company_question (company_id, question_id)
);

CREATE TABLE IF NOT EXISTS company_roadmap (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    title VARCHAR(500),
    description VARCHAR(2000),
    source_type VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roadmap_step (
    id BIGINT NOT NULL AUTO_INCREMENT,
    roadmap_id BIGINT NOT NULL,
    sequence_number INT NOT NULL,
    phase VARCHAR(500),
    week_or_day VARCHAR(100),
    subject VARCHAR(500),
    topic VARCHAR(500),
    activity VARCHAR(500),
    description VARCHAR(2000),
    difficulty VARCHAR(100),
    source_type VARCHAR(100),
    PRIMARY KEY (id)
);

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE preparation_question ADD COLUMN difficulty TEXT', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'preparation_question' AND column_name = 'difficulty');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE task ADD COLUMN user_id BIGINT NULL', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'task' AND column_name = 'user_id');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE dsa_progress ADD COLUMN user_id BIGINT NULL', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'dsa_progress' AND column_name = 'user_id');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE sql_progress ADD COLUMN user_id BIGINT NULL', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'sql_progress' AND column_name = 'user_id');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE revision_progress ADD COLUMN user_id BIGINT NULL', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'revision_progress' AND column_name = 'user_id');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE bookmark ADD COLUMN user_id BIGINT NULL', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'bookmark' AND column_name = 'user_id');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE contest ADD COLUMN user_id BIGINT NULL', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'contest' AND column_name = 'user_id');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

SET @migration_sql = (SELECT IF(COUNT(*) = 0, 'ALTER TABLE job ADD COLUMN user_id BIGINT NULL', 'SELECT 1') FROM information_schema.columns WHERE table_schema = DATABASE() AND table_name = 'job' AND column_name = 'user_id');
PREPARE migration_statement FROM @migration_sql;
EXECUTE migration_statement;
DEALLOCATE PREPARE migration_statement;

