INSERT INTO `osbb_example`.`buildings` (`address`) VALUES ('Sajevicha, 5');
INSERT INTO `osbb_example`.`buildings` (`address`) VALUES ('Sajevicha, 6');
INSERT INTO `osbb_example`.`buildings` (`address`) VALUES ('Sajevicha, 7');

INSERT INTO `osbb_example`.`flats` (`number`, `level`, `square`, `building_id`) VALUES ('101', '1', '32.16', '1');
INSERT INTO `osbb_example`.`flats` (`number`, `level`, `square`, `building_id`) VALUES ('102', '1', '46.8', '1');
INSERT INTO `osbb_example`.`flats` (`number`, `level`, `square`, `building_id`) VALUES ('103', '1', '57.8', '1');

INSERT INTO `osbb_example`.`members` (`names`) VALUES ('Махно Олександр');
INSERT INTO `osbb_example`.`members` (`names`) VALUES ('Копский Микола');
INSERT INTO `osbb_example`.`members` (`names`) VALUES ('Шульман Олексій');

INSERT INTO `osbb_example`.`members_role` (`role`, `member_id`) VALUES ('staff', '1');
INSERT INTO `osbb_example`.`members_role` (`role`, `member_id`) VALUES ('member', '1');
INSERT INTO `osbb_example`.`members_role` (`role`, `member_id`) VALUES ('member', '2');

INSERT INTO `osbb_example`.`membrrts_to_flats` (`member_id`, `flat_id`) VALUES ('1', '1');
INSERT INTO `osbb_example`.`membrrts_to_flats` (`member_id`, `flat_id`) VALUES ('2', '2');
INSERT INTO `osbb_example`.`membrrts_to_flats` (`member_id`, `flat_id`) VALUES ('3', '3');

INSERT INTO `osbb_example`.`tenants` (`names`, `flat_id`) VALUES ('Мораєв Владлен', '1');
INSERT INTO `osbb_example`.`tenants` (`names`, `member_id`, `flat_id`) VALUES ('Копский Микола', '2', '2');
INSERT INTO `osbb_example`.`tenants` (`names`, `flat_id`) VALUES ('ЗАджніпровсткй Дмитрой', '3');
