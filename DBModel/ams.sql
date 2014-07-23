-- 수강신청
DROP TABLE IF EXISTS SUB_REQS RESTRICT;

-- 강사
DROP TABLE IF EXISTS TEACHERS RESTRICT;

-- 수강생
DROP TABLE IF EXISTS STUDENTS RESTRICT;

-- 회원사진
DROP TABLE IF EXISTS MEM_PHOTOS RESTRICT;

-- 과목
DROP TABLE IF EXISTS SUBJECTS RESTRICT;

-- 회원
DROP TABLE IF EXISTS MEMBERS RESTRICT;

-- 수강신청
CREATE TABLE SUB_REQS (
  SRNO       INTEGER     NOT NULL COMMENT '수강신청일련번호', -- 수강신청일련번호
  SUBNO      INTEGER     NOT NULL COMMENT '과목일련번호', -- 과목일련번호
  MNO        INTEGER     NOT NULL COMMENT '수강생일련번호', -- 수강생일련번호
  REG_DATE   DATETIME    NOT NULL COMMENT '신청일', -- 신청일
  PAY_YN     CHAR(1)     NULL     COMMENT '결제여부', -- 결제여부
  PAY_METHOD VARCHAR(90) NULL     COMMENT '결제방법', -- 결제방법
  PAY_DATE   DATETIME    NULL     COMMENT '결제일' -- 결제일
)
COMMENT '수강신청';

-- 수강신청
ALTER TABLE SUB_REQS
  ADD CONSTRAINT PK_SUB_REQS -- 수강신청 기본키
    PRIMARY KEY (
      SRNO -- 수강신청일련번호
    );

ALTER TABLE SUB_REQS
  MODIFY COLUMN SRNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '수강신청일련번호';

-- 강사
CREATE TABLE TEACHERS (
  MNO      INTEGER     NOT NULL COMMENT '강사일련번호', -- 강사일련번호
  POSITION VARCHAR(90) NULL     COMMENT '직책' -- 직책
)
COMMENT '강사';

-- 강사
ALTER TABLE TEACHERS
  ADD CONSTRAINT PK_TEACHERS -- 강사 기본키
    PRIMARY KEY (
      MNO -- 강사일련번호
    );

-- 수강생
CREATE TABLE STUDENTS (
  MNO       INTEGER      NOT NULL COMMENT '수강생일련번호', -- 수강생일련번호
  POST_NO   VARCHAR(20)  NULL     COMMENT '우편번호', -- 우편번호
  BAS_ADDR  VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
  DET_ADDR  VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  SCHOOL    VARCHAR(90)  NULL     COMMENT '학교', -- 학교
  GRADE     VARCHAR(90)  NULL     COMMENT '학년', -- 학년
  MAJOR     VARCHAR(90)  NULL     COMMENT '전공', -- 전공
  WORKING   CHAR(1)      NULL     COMMENT '재직자여부', -- 재직자여부
  COMPANY   VARCHAR(90)  NULL     COMMENT '회사', -- 회사
  COMP_CODE VARCHAR(20)  NULL     COMMENT '사업자번호' -- 사업자번호
)
COMMENT '수강생';

-- 수강생
ALTER TABLE STUDENTS
  ADD CONSTRAINT PK_STUDENTS -- 수강생 기본키
    PRIMARY KEY (
      MNO -- 수강생일련번호
    );

-- 회원사진
CREATE TABLE MEM_PHOTOS (
  MPNO      INTEGER      NOT NULL COMMENT '사진일련번호', -- 사진일련번호
  MNO       INTEGER      NOT NULL COMMENT '회원일련번호', -- 회원일련번호
  FILE_PATH VARCHAR(255) NOT NULL COMMENT '수강생사진' -- 수강생사진
)
COMMENT '회원사진';

-- 회원사진
ALTER TABLE MEM_PHOTOS
  ADD CONSTRAINT PK_MEM_PHOTOS -- 회원사진 기본키
    PRIMARY KEY (
      MPNO -- 사진일련번호
    );

ALTER TABLE MEM_PHOTOS
  MODIFY COLUMN MPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '사진일련번호';

-- 과목
CREATE TABLE SUBJECTS (
  SUBNO    INTEGER      NOT NULL COMMENT '과목일련번호', -- 과목일련번호
  TITLE    VARCHAR(255) NOT NULL COMMENT '과목명', -- 과목명
  CLASS    VARCHAR(90)  NULL     COMMENT '교실', -- 교실
  DESCR    TEXT         NOT NULL COMMENT '과목설명', -- 과목설명
  CAPACITY INTEGER      NOT NULL COMMENT '수강가능인원', -- 수강가능인원
  MNO      INTEGER      NULL     COMMENT '강사일련번호' -- 강사일련번호
)
COMMENT '과목';

-- 과목
ALTER TABLE SUBJECTS
  ADD CONSTRAINT PK_SUBJECTS -- 과목 기본키
    PRIMARY KEY (
      SUBNO -- 과목일련번호
    );

-- 과목 인덱스
CREATE INDEX IX_SUBJECTS
  ON SUBJECTS( -- 과목
    TITLE ASC -- 과목명
  );

ALTER TABLE SUBJECTS
  MODIFY COLUMN SUBNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '과목일련번호';

-- 회원
CREATE TABLE MEMBERS (
  MNO   INTEGER     NOT NULL COMMENT '회원일련번호', -- 회원일련번호
  NAME  VARCHAR(90) NOT NULL COMMENT '이름', -- 이름
  EMAIL VARCHAR(40) NOT NULL COMMENT '이메일', -- 이메일
  TEL   VARCHAR(30) NOT NULL COMMENT '전화', -- 전화
  PWD   VARCHAR(40) NOT NULL COMMENT '암호' -- 암호
)
COMMENT '회원';

-- 회원
ALTER TABLE MEMBERS
  ADD CONSTRAINT PK_MEMBERS -- 회원 기본키
    PRIMARY KEY (
      MNO -- 회원일련번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_MEMBERS
  ON MEMBERS ( -- 회원
    EMAIL ASC -- 이메일
  );

-- 회원 인덱스
CREATE INDEX IX_MEMBERS
  ON MEMBERS( -- 회원
    NAME ASC -- 이름
  );

ALTER TABLE MEMBERS
  MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원일련번호';

-- 수강신청
ALTER TABLE SUB_REQS
  ADD CONSTRAINT FK_STUDENTS_TO_SUB_REQS -- 수강생 -> 수강신청
    FOREIGN KEY (
      MNO -- 수강생일련번호
    )
    REFERENCES STUDENTS ( -- 수강생
      MNO -- 수강생일련번호
    );

-- 수강신청
ALTER TABLE SUB_REQS
  ADD CONSTRAINT FK_SUBJECTS_TO_SUB_REQS -- 과목 -> 수강신청
    FOREIGN KEY (
      SUBNO -- 과목일련번호
    )
    REFERENCES SUBJECTS ( -- 과목
      SUBNO -- 과목일련번호
    );

-- 강사
ALTER TABLE TEACHERS
  ADD CONSTRAINT FK_MEMBERS_TO_TEACHERS -- 회원 -> 강사
    FOREIGN KEY (
      MNO -- 강사일련번호
    )
    REFERENCES MEMBERS ( -- 회원
      MNO -- 회원일련번호
    );

-- 수강생
ALTER TABLE STUDENTS
  ADD CONSTRAINT FK_MEMBERS_TO_STUDENTS -- 회원 -> 수강생
    FOREIGN KEY (
      MNO -- 수강생일련번호
    )
    REFERENCES MEMBERS ( -- 회원
      MNO -- 회원일련번호
    );

-- 회원사진
ALTER TABLE MEM_PHOTOS
  ADD CONSTRAINT FK_MEMBERS_TO_MEM_PHOTOS -- 회원 -> 회원사진
    FOREIGN KEY (
      MNO -- 회원일련번호
    )
    REFERENCES MEMBERS ( -- 회원
      MNO -- 회원일련번호
    );

-- 과목
ALTER TABLE SUBJECTS
  ADD CONSTRAINT FK_TEACHERS_TO_SUBJECTS -- 강사 -> 과목
    FOREIGN KEY (
      MNO -- 강사일련번호
    )
    REFERENCES TEACHERS ( -- 강사
      MNO -- 강사일련번호
    );