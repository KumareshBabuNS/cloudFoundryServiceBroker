INSERT INTO `cf_6f9ef31d_e8bb_4683_9e84_8537708795d5`.`services`
(`id`,
`bindable`,
`description`,
`name`)
VALUES
(`1`,
true,
`Weather app to get and set temperatures for cities`,
`Weather-Service`);

INSERT INTO `cf_6f9ef31d_e8bb_4683_9e84_8537708795d5`.`plans`
(`id`,
`description`,
`name`,
`service_id`)
VALUES
(`1`,
`Unlimited free plan for users`,
`Free-Plan`,
`1`);