-- Ad Accounts table
CREATE TABLE ad_accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ad_account_id CHAR(36) UNIQUE NOT NULL,
    owner_id CHAR(36) NOT NULL,
    name VARCHAR(100) NOT NULL,
    status VARCHAR(30) NOT NULL,
    parent_account_id CHAR(36),
    billing_info JSON,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    INDEX idx_owner_id (owner_id),
    INDEX idx_parent_account_id (parent_account_id),
    INDEX idx_status (status),
    INDEX idx_created_at (created_at)
);

-- Account Members table
CREATE TABLE ad_account_members (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ad_account_id CHAR(36) NOT NULL,
    ad_user_id CHAR(36) NOT NULL,
    role VARCHAR(20) NOT NULL,
    invited_by CHAR(36) NOT NULL,
    accepted_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    UNIQUE KEY uk_account_user (ad_account_id, ad_user_id),
    INDEX idx_ad_account_id (ad_account_id),
    INDEX idx_ad_user_id (ad_user_id),
    INDEX idx_role (role),
    INDEX idx_created_at (created_at)
);

-- Account Budgets table
CREATE TABLE ad_account_budgets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ad_account_id CHAR(36) NOT NULL,
    budget_type VARCHAR(20) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    start_date DATE,
    end_date DATE,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    INDEX idx_ad_account_id (ad_account_id),
    INDEX idx_budget_type (budget_type),
    INDEX idx_start_date (start_date),
    INDEX idx_end_date (end_date),
    INDEX idx_created_at (created_at)
);

-- Audit Log table
CREATE TABLE ad_account_audit_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ad_account_id CHAR(36) NOT NULL,
    action VARCHAR(100) NOT NULL,
    performed_by CHAR(36) NOT NULL,
    details JSON,
    created_at TIMESTAMP NOT NULL,
    INDEX idx_ad_account_id (ad_account_id),
    INDEX idx_created_at (created_at),
    INDEX idx_performed_by (performed_by),
    INDEX idx_action (action)
);