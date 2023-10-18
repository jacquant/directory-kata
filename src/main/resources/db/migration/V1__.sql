CREATE SEQUENCE address_seq MINVALUE 1
    MAXVALUE 999999999
    INCREMENT BY 1
    START WITH 5
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE company_seq MINVALUE 1
    MAXVALUE 999999999
    INCREMENT BY 1
    START WITH 3
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE contact_seq MINVALUE 1
    MAXVALUE 999999999
    INCREMENT BY 1
    START WITH 3
    NOCACHE
    NOCYCLE;

CREATE TABLE address
(
    id           BIGINT       NOT NULL,
    address_type VARCHAR(31),
    street       VARCHAR(255) NOT NULL,
    city         VARCHAR(255) NOT NULL,
    zip_code     VARCHAR(255) NOT NULL,
    country      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE company
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NOT NULL,
    address_id BIGINT,
    vat_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_company PRIMARY KEY (id)
);

CREATE TABLE contact
(
    id         BIGINT       NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    vat_number VARCHAR(255),
    address_id BIGINT,
    CONSTRAINT pk_contact PRIMARY KEY (id)
);

CREATE TABLE contact_companies
(
    contact_entity_id BIGINT NOT NULL,
    companies_id      BIGINT NOT NULL
);

ALTER TABLE company
    ADD CONSTRAINT FK_COMPANY_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE contact
    ADD CONSTRAINT FK_CONTACT_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE contact_companies
    ADD CONSTRAINT fk_concom_on_company_entity FOREIGN KEY (companies_id) REFERENCES company (id);

ALTER TABLE contact_companies
    ADD CONSTRAINT fk_concom_on_contact_entity FOREIGN KEY (contact_entity_id) REFERENCES contact (id);


// FILL DATABASE WITH INITIAL_DATA
INSERT INTO address (id, address_type, street, city, zip_code, country)
VALUES (1, 'COMPANY', 'Rue de la gare 1', 'Paris', '75001', 'France');
INSERT INTO address (id, address_type, street, city, zip_code, country)
VALUES (2, 'CONTACT', 'Rue de la gare 2', 'Paris', '75001', 'France');
INSERT INTO address (id, address_type, street, city, zip_code, country)
VALUES (3, 'COMPANY', 'Rue de la gare 3', 'Paris', '75001', 'France');
INSERT INTO address (id, address_type, street, city, zip_code, country)
VALUES (4, 'CONTACT', 'Rue de la gare 4', 'Paris', '75001', 'France');

INSERT INTO company (id, name, address_id, vat_number)
VALUES (1, 'Company 1', 1, 'BE0123456789');
INSERT INTO company (id, name, address_id, vat_number)
VALUES (2, 'Company 2', 3, 'BE9876543210');

INSERT INTO contact (id, last_name, first_name, type, vat_number, address_id)
VALUES (1, 'ANTOINE', 'JACQUES', 'FREELANCE', 'BE0123456789', 2);
INSERT INTO contact (id, last_name, first_name, type, vat_number, address_id)
VALUES (2, 'DUPONT', 'JEAN', 'EMPLOYEE', 'BE9876543210', 4);

INSERT INTO contact_companies (contact_entity_id, companies_id)
VALUES (1, 1);
INSERT INTO contact_companies (contact_entity_id, companies_id)
VALUES (1, 2);
INSERT INTO contact_companies (contact_entity_id, companies_id)
VALUES (2, 2);