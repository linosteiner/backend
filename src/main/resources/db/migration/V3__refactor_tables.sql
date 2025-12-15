ALTER TABLE sub_category
    RENAME COLUMN high_val TO high;

ALTER TABLE sub_category
    RENAME COLUMN low_val TO low;

ALTER TABLE measurement
    RENAME COLUMN "user" TO person;

ALTER TABLE statistic
    RENAME COLUMN rank_val TO rank;
