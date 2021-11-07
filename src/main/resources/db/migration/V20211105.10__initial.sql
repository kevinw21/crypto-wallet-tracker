create table if not exists crypto_parent_entity
(
    uuid                     varchar(36) NOT NULL,
    name                     varchar(36),
    symbol                   varchar(20) NOT NULL,
    wallet                   varchar(36)  NOT NULL,
    average_price            double precision NOT NULL,
    total_value              real NOT NULL,
    total_coins              real NOT NULL,
    total_fees               real NOT NULL,

    PRIMARY KEY (uuid)
);

create table if not exists crypto_purchase_entity
(
    uuid                      varchar(36) NOT NULL,
    purchased_exchange        varchar(36)  NOT NULL,
    value                     real NOT NULL,
    coins                     real NOT NULL,
    crypto_parent_entity_uuid varchar(36) NOT NULL,
    average_price             double precision NOT NULL,
    fee                      double precision NOT NULL,

    PRIMARY KEY (uuid),
    FOREIGN KEY (crypto_parent_entity_uuid) REFERENCES crypto_parent_entity(uuid) ON DELETE CASCADE
);
