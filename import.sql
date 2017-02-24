INSERT INTO `services`
(
`id`,
`bindable`,
`description`,
`name`)
VALUES
(
'1',
true,
'Weather app to get and set temperatures for cities',
'Weather-Service');

INSERT INTO `plans`
(`id`,
`description`,
`name`,
`service_id`)
VALUES
('1',
'Unlimited free plan for users',
'Free-Plan',
'1');