create table if not exists crypto_parent_entity
(
    uuid                     varchar(36) NOT NULL,
    name                     varchar(36),
    symbol                   varchar(20) NOT NULL,
    wallet                   varchar(36)  NOT NULL,
    average_price            double precision NOT NULL,

    PRIMARY KEY (uuid)
);

create table if not exists crypto_purchase_entity
(
    uuid                     varchar(36) NOT NULL,
    purchased_exchange       varchar(36)  NOT NULL,
    total_value              real NOT NULL,
    coins                    real NOT NULL,

    PRIMARY KEY (uuid)
);

create table if not exists crypto_parent_purchases
(
    crypto_parent_entity_uuid varchar(36) NOT NULL,
    purchase_uuid            varchar(36) NOT NULL
);