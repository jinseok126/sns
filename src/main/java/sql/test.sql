
DROP PROCEDURE IF EXISTS demo_proc$$

DELIMITER $$
CREATE PROCEDURE demo_for_proc()

BEGIN

	DECLARE i INT DEFAULT 1;

	WHILE i <= 100 DO

		INSERT INTO tbl_member(member_id, member_pw, member_name, member_date)
          VALUES (concat('test_',i), concat('1234'), concat('테스트_',i), now());
		SET i = i + 1;
	END WHILE;

END$$

DELIMITER $$

Call demo_for_proc(); 