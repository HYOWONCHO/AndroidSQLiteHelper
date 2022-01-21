package com.example.mysql_test;

public class GradeJudgementDataListViewItem {
    String SEQ;    			         //!< 입력번호
    String ABATT_NO;    			 //!< 도축번호
    String MCHN_BACKFAT;    	     //!< 등지방두께
    String MCHN_BACKFAT_PXL;    	 //!< 등지방영역픽셀
    String MCHN_REA;    			 //!< 등심단면적 표준
    String MCHN_REA_STDUNIT;    	 //!< 등심단면적 표준단위
    String MCHN_REA_UNIT1;    		 //!< 등심단면적 (0.125cm2 )
    String MCHN_REA_UNIT2;    		 //!< 등심단면적 (0.5cm2)
    String MCHN_REA_UNIT3;    		 //!< 등심단면적 (1cm2)
    String MCHN_INSFAT_MTHD1;    	 //!< 근내지방도 (AI 알고리즘)
    String MCHN_INSFAT_MTHD1_DTL;    //!< 기계근내지방도알고리즘1 세부등급
    String MCHN_INSFAT_MTHD1_RT;     //!< 근내지방도 비율 (%)
    String MCHN_INSFAT_MTHD2;    	 //!< 근내지방도 (이진화 알고리즘)
    String MCHN_INSFAT_MTHD2_DTL;    //!< 기계근내지방도알고리즘2 세부등급
    String MCHN_INSFAT_MTHD2_RT;     //!< 근내지방도 비율 (%)
    String MCHN_YUKSAK;    			 //!< 육색 등급
    String MCHN_YUKSAK_RGB_R;    	 //!< 육색 R (RGB)
    String MCHN_YUKSAK_RGB_G;    	 //!< 육색 G (RGB)
    String MCHN_YUKSAK_RGB_B;    	 //!< 육색 B (RGB)
    String MCHN_YUKSAK_LAB_L;    	 //!< 육색 L (LAB)
    String MCHN_YUKSAK_LAB_A;    	 //!< 육색 A (LAB)
    String MCHN_YUKSAK_LAB_B;    	 //!< 육색 B (LAB)
    String MCHN_FATSAK;    			 //!< 지방색 등급
    String MCHN_FATSAK_RGB_R;    		 //!< 지방색 R (RGB)
    String MCHN_FATSAK_RGB_G;    		 //!< 지방색 G (RGB)
    String MCHN_FATSAK_RGB_B;    		 //!< 지방색 B (RGB)
    String MCHN_FATSAK_LAB_L;    		 //!< 지방색 L (LAB)
    String MCHN_FATSAK_LAB_A;    		 //!< 지방색 A (LAB)
    String MCHN_FATSAK_LAB_B;    		 //!< 지방색 B (LAB)
    String MCHN_TISSUE;    			 //!< 조직감 등급
    String MCHN_TISSUE_LOUGH;    			 //!< 조직감 거침도
    String JUDGE_BREED;    			 //!<  품종
    String JUDGE_SEX;    			 //!< 성별
    String BACKFAT;    			     //!< 인력
    //String MCHN_BACKFAT;    		 //!< 기계
    //String REA;    			        //!< 인력
    //String MCHN_REA;    			 //!< 기계
    String WEIGHT;    			 //!< 중량
    String WINDEX;    			 //!< 지수
    String WGRADE;    			 //!< 육량등급
    String QGRADE;    			 //!< 육질(최종등급)
    String UPDOWN_CODE;    			 //!< 육량(최종등급)
    String LAST_GRADE;    			 //!< 인력(최종등급)
    String MCHN_LAST_GRADE;    			 //!< 기계(최종등급)
    String DEFECT_CODE;    			 //!< 결함코드
    String DEFECT_DTL_CODE;    			 //!< 등외번호
    String YUKSAK;    			 //!< 인력
    //String MCHN_YUKSAK;    			 //!< 기계
    String INSFAT;    			 //!< 인력
    String INSFAT_DTL;    			 //!<
    String MCHN_INSFAT;    			 //!< 기계
    String MCHN_INSFAT_DTL;    			 //!<
    String FATSAK;    			 //!< 인력
    //String MCHN_FATSAK;    			 //!< 기계
    String TISSUE;    			 //!< 인력
    //String MCHN_TISSUE;    			 //!< 기계
    String GROWTH;    			 //!< 성숙도
    String REG_HMS;    			 //!< 판정시간

    public class obj_BACKFAT {
        private Integer n_backfat;
        private Integer n_mchn_backfat;

        public obj_BACKFAT(String backfat, String mchn_backfat) {
            n_backfat = Integer.parseInt(backfat.toString());
            n_mchn_backfat = Integer.parseInt(mchn_backfat.toString());
        }

        public void get(Integer backfat, Integer mchnbackfat) {
            backfat = n_backfat;
            mchnbackfat = n_mchn_backfat;
        }
    }

    public class obj_JGMTREA {
        private Integer n_rea;
        private Integer n_mchnrea;

        public obj_JGMTREA(String rea, String mchnrea) {
            n_rea = Integer.parseInt(rea.toString());
            n_mchnrea = Integer.parseInt(mchnrea.toString());
        }

        public void get(Integer rea, Integer mchnrea) {
            rea = n_rea;
            mchnrea = n_mchnrea;
        }
    }

    public class obj_JGMTYUKSAK {
        private String number;
        private String machine;
        private String grade;

        public obj_JGMTYUKSAK(String number, String rgb, String grade) {
            this.number = number;
            this.machine = rgb;
            this.grade = grade;
        }

        public void get(String number, String rgb, String grade) {
            number = this.number;
            rgb = this.machine;
            grade = this.grade;
        }
    }

    private Object m_handle = null;
    //private ArrayList<GradeJudgementDataListViewItem> m_itemhandle = null;
    public GradeJudgementDataListViewItem(ConstColumnNames handle) {
        try {
            if (handle == null) {
                throw new Exception("Input Arg of GradeJudgementDataListViewItem constructor is NULL");
            }

            m_handle = (Object)handle;
            set_JudgementDataOnListViewItem(m_handle);
            //_gjdvi = handle;
            // copy of this input argument ArrayList instance
            //this.m_handle = handle.clone();
            //this.m_itemhandle = new ArrayList<GradeJudgementDataListViewItem>;
        }
        catch (Exception e) {
            DBLog.e("GradeJudgementDataListViewItem", "Exception", e);
        }
    }

    private void set_JudgementDataOnListViewItem (Object handle) {
        ConstColumnNames h = (ConstColumnNames)handle;

        this.SEQ						=	h.SEQ;
        this.ABATT_NO						=	h.ABATT_NO;
        this.MCHN_BACKFAT						=	h.MCHN_BACKFAT;
        this.MCHN_BACKFAT_PXL						=	h.MCHN_BACKFAT_PXL;
        this.MCHN_REA						=	h.MCHN_REA;
        this.MCHN_REA_STDUNIT						=	h.MCHN_REA_STDUNIT;
        this.MCHN_REA_UNIT1						=	h.MCHN_REA_UNIT1;
        this.MCHN_REA_UNIT2						=	h.MCHN_REA_UNIT2;
        this.MCHN_REA_UNIT3						=	h.MCHN_REA_UNIT3;
        this.MCHN_INSFAT_MTHD1						=	h.MCHN_INSFAT_MTHD1;
        this.MCHN_INSFAT_MTHD1_DTL						=	h.MCHN_INSFAT_MTHD1_DTL;
        this.MCHN_INSFAT_MTHD1_RT						=	h.MCHN_INSFAT_MTHD1_RT;
        this.MCHN_INSFAT_MTHD2						=	h.MCHN_INSFAT_MTHD2;
        this.MCHN_INSFAT_MTHD2_DTL						=	h.MCHN_INSFAT_MTHD2_DTL;
        this.MCHN_INSFAT_MTHD2_RT						=	h.MCHN_INSFAT_MTHD2_RT;
        this.MCHN_YUKSAK						=	h.MCHN_YUKSAK;
        this.MCHN_YUKSAK_RGB_R						=	h.MCHN_YUKSAK_RGB_R;
        this.MCHN_YUKSAK_RGB_G						=	h.MCHN_YUKSAK_RGB_G;
        this.MCHN_YUKSAK_RGB_B						=	h.MCHN_YUKSAK_RGB_B;
        this.MCHN_YUKSAK_LAB_L						=	h.MCHN_YUKSAK_LAB_L;
        this.MCHN_YUKSAK_LAB_A						=	h.MCHN_YUKSAK_LAB_A;
        this.MCHN_YUKSAK_LAB_B						=	h.MCHN_YUKSAK_LAB_B;
        this.MCHN_FATSAK						=	h.MCHN_FATSAK;
        this.MCHN_FATSAK_RGB_R						=	h.MCHN_FATSAK_RGB_R;
        this.MCHN_FATSAK_RGB_G						=	h.MCHN_FATSAK_RGB_G;
        this.MCHN_FATSAK_RGB_B						=	h.MCHN_FATSAK_RGB_B;
        this.MCHN_FATSAK_LAB_L						=	h.MCHN_FATSAK_LAB_L;
        this.MCHN_FATSAK_LAB_A						=	h.MCHN_FATSAK_LAB_A;
        this.MCHN_FATSAK_LAB_B						=	h.MCHN_FATSAK_LAB_B;
        this.MCHN_TISSUE						=	h.MCHN_TISSUE;
        this.MCHN_TISSUE_LOUGH						=	h.MCHN_TISSUE_ROUGH;
        this.JUDGE_BREED						=	h.JUDGE_BREED;
        this.JUDGE_SEX						=	h.JUDGE_SEX;
        this.BACKFAT						=	h.BACKFAT;
        this.MCHN_BACKFAT						=	h.MCHN_BACKFAT;
        //this.MCHN_REA						=	h.REA;
        this.MCHN_REA						=	h.MCHN_REA;
        this.WEIGHT						=	h.WEIGHT;
        this.WINDEX						=	h.WINDEX;
        this.WGRADE						=	h.WGRADE;
        this.QGRADE						=	h.QGRADE;
        this.UPDOWN_CODE						=	h.UPDOWN_CODE;
        this.LAST_GRADE						=	h.LAST_GRADE;
        this.MCHN_LAST_GRADE						=	h.MCHN_LAST_GRADE;
        this.DEFECT_CODE						=	h.DEFECT_CODE;
        this.DEFECT_DTL_CODE						=	h.DEFECT_DTL_CODE;
        this.YUKSAK						=	h.YUKSAK;
        this.MCHN_YUKSAK						=	h.MCHN_YUKSAK;
        this.INSFAT						=	h.INSFAT;
        this.INSFAT_DTL						=	h.INSFAT_DTL;
        this.MCHN_INSFAT						=	h.INSFAT;
        this.MCHN_INSFAT_DTL						=	h.INSFAT_DTL;
        this.FATSAK						=	h.FATSAK;
        this.MCHN_FATSAK						=	h.MCHN_FATSAK;
        this.TISSUE						=	h.TISSUE;
        this.MCHN_TISSUE						=	h.MCHN_TISSUE;
        this.GROWTH						=	h.GROWTH;
        this.REG_HMS						=	h.REG_HMS;
    }

    //public BACKFAT get_BACKFAT() {
     //   BACKFAT = new BACKFAT();
   // }






}
