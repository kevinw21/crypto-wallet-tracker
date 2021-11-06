create table if not exists crypto_market_entity
(
    uuid                     varchar(36) NOT NULL,
    name                     varchar(36) NOT NULL,
    purchased_exchange       varchar(36)  NOT NULL,
    wallet                   varchar(36)  NOT NULL,
    total_value              real NOT NULL,
    average_price            double precision NOT NULL,
    coins                    real NOT NULL,

    PRIMARY KEY (uuid)
);