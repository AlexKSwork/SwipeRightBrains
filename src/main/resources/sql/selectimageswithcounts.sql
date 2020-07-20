-- -----------------------------------------------------
-- SP `brainschema`.`selectAllImagesWithCount`
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS  selectAllImagesWithCount;
Delimiter //
CREATE PROCEDURE selectAllImagesWithCount()
BEGIN
        SELECT img.id as id,img.path as path,img.known_good as known_good,
        (SELECT count(*) FROM userrating WHERE imageid=img.id and response=1) as good_responses,
        (SELECT count(*) FROM userrating WHERE imageid=img.id and response=0) as bad_responses,
        (SELECT count(*) FROM userrating WHERE imageid=img.id) as total,
        ROUND(((SELECT count(*) FROM userrating WHERE imageid=img.id and response=1) * 100) / 
        (SELECT count(*) FROM userrating WHERE imageid=img.id), 2) as good_responses_per,
        ROUND(((SELECT count(*) FROM userrating WHERE imageid=img.id and response=0) * 100) / 
        (SELECT count(*) FROM userrating WHERE imageid=img.id), 2) as bad_responses_per FROM images img;
END //
DELIMITER ;

CALL selectAllImagesWithCount