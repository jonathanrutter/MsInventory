/* Update file for flyway database updater */
/* next update will be called 'V2__DoSomethingElse.sql' */
/*
WARNING when initialising the databases on first application start up this file
causes problems as it tries to update the database before they are created
 */
CREATE TABLE t_inventory (
    id bigint(20)   NOT NULL AUTO_INCREMENT,
    sku_code        varchar(255),
    quantity        int(11),
    PRIMARY KEY (id)
);