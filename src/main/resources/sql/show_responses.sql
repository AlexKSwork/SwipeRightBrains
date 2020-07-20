USE brainschema;
DROP procedure IF EXISTS new_procedure;

DELIMITER $$

CREATE PROCEDURE brainschema.new_procedure()
BEGIN
SELECT * FROM userrating;
SELECT * FROM userresponse;
END
$$

CALL brainschema.new_procedure