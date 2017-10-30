package com.yangwei.www.adapter;

import java.util.List;

/**
 * Created by yangwei on 2017/10/30.
 */

public class A {

    /**
     * errorDesc :
     * responseBody : {"busiCode":"ZYB10","interfaceNo":"1010","intoInfoList":[{"appProductType":"PTL170600124","auditeState":"1200","cardId":"370501199901019736","cardType":"1","createTime":"1507901582296","custName":"都好久","customerChannel":"6","customerManager":"11050226","customerService":"11050226","fkCustCode":"CR20171001217335","intoAppId":"120153671006","intoInfoStore":"301001205","loanType":"1","manageStore":"301001205","minAppAmount":"466","prodMoneyType":"CNY","prodUrgentRate":"","remark":"好大家大家"}],"lbtCustomerBasic":[{"afterTaxMonthlyIncome":"66","cardEndT":"9999-12-31","cardStartT":"2017-10-13","ccurrentAreacode":"","childCount":"","chometownAreacode":"","currentAddr":"新华大街","currentAreacode":"110101","customerSource":"2","email":"djsj@sina.com","famMonPay":"664","hMonPayment":"","hasChild":"0","hasTelephone":"0","hdegree":"","homePartner":"1","homeType":"1","hometownAddr":"都开始看看","hometownAreacode":"110101","inCityYear":"1987","longTerm":"","marrStatus":"1","maxCreditAmount":"66","mobilePhone":"17612237949","nation":"1","pcurrentAreacode":"","phometownAreacode":"","telephoneAreaCode":"","sex":"1","telphone":"17612237949"}],"lbtCustomerJob":[{"cjAddrAreacode":"","jAddr":"大家大家","jAddrAreacode":"110101","jDept":"电话","jEnterT":"1507824000000","jMonIncome":"66.0","jMonPayT":"55","jName":"倒计时几","jPayType":"1","jPhone":"222222","jPhoneAreaCode":"222","jPosition":"5","jType":"1","pjAddrAreacode":""}],"lbtIntoInfoBankCard":[{"accountName":"在哪开始","bankCardAccount":"12345678911","bankCityAreacode":"110100","bankCode":"102","bankProvAreacode":"110000","bankReservedPhone":"17612237949","isLoanType":"1","isReceiveType":"1","subBranchName":"大家打开"}],"lbtIntoInfoBasic":[{"applyPeriod":"3","familyIsKnown":"0","isEms":"0","loanPurpose":"1","loanPurposeDetail":"红红火火恍恍惚惚","monthPayment":"66","prodRepaymentWay":"AC10001","prodServiceRate":"2.45"}],"lbtIntoInfoContact":[{"cconHomeAreacode":"","cconJobAreacode":"","conCompany":"还在家睡觉","conHomeAreacode":"110101","conHomeDetailAddr":"睡觉睡觉睡觉","conJobAreacode":"110101","conJobDetailAddr":"都不睡觉","conName":"色即是空开始2","conPhone":"17612237949","conRelation":"0","contactDuty":"","contactType":"3","pconHomeAreacode":"","pconJobAreacode":""},{"cconHomeAreacode":"","cconJobAreacode":"","conCompany":"大家上课","conHomeAreacode":"110101","conHomeDetailAddr":"耍手机","conJobAreacode":"110101","conJobDetailAddr":"死就死","conName":"睡觉的健康","conPhone":"17612237949","conRelation":"0","contactDuty":"","contactType":"3","pconHomeAreacode":"","pconJobAreacode":""},{"cconHomeAreacode":"","cconJobAreacode":"","conCompany":"","conHomeAreacode":"","conHomeDetailAddr":"","conJobAreacode":"","conJobDetailAddr":"","conName":"这就是看看","conPhone":"17612237949","conRelation":"0","contactDuty":"","contactType":"2","pconHomeAreacode":"","pconJobAreacode":""}],"lbtIntoInfoHouse":[{"chouseAddrAreacode":"","hPost":"","houseAddrAreacode":"110101","houseBuildArea":"66","houseDetailAddr":"赶紧睡觉大家","houseLoBalance":"","houseLoYearLimit":"33","houseMonthlyPayment":"33.0","housePrice":"55","houseProRightRate":"","housePurchasedYears":"66","houseType":"1","phouseAddrAreacode":""}],"lbtIntoInfoInsurPolicy":[{"contractEffectDate":"1507824000000","firstPaymentDate":"1507824000000","insuranceAmount":"664","insurancePeriod":"","insurancePremium":"664","isLifelong":"1","payPeriod":"646.0","paymentMethod":"1"}],"lbtIntoInfoManage":[{"comAddr":"1","comEmpCount":"1","comType":"1","houseLoBalance":"","houseMonthlyPayment":"","houseProRightRate":"","registerDate":"1507824000000","shareholdRatio":"66.0"}],"lbtIntoInfoUpload":[{"attachId":"B1","attachSize":"400k","attachType":"B1","name":"B1_01.jpg","url":"group1/M00/0A/08/rBJkLVngw2yAH5m8ADOn4ic_6lY324.jpg"},{"attachId":"C1","attachSize":"400k","attachType":"C1","name":"C1_01.jpg","url":"group1/M00/0A/08/rBJkLVngw2yAU4YoADOn4ic_6lY247.jpg"},{"attachId":"A1","attachSize":"400k","attachType":"A1","name":"A1_01.jpg","url":"group1/M00/0A/08/rBJkLVngw2yAAYBnADOn4ic_6lY505.jpg"}],"lbtLiability":[{"accCAuditCount":"","accQCount":"3","cardSumDebt":"","credit24ContinueOverdue":"","credit24Overdue":"","credit24OverdueCount":"","creditReportState":"1","creditVersionType":"0","currOverdueAmount":"","debtSum":"","enableCreditCrad":"","incomeDebtRatio":"","isLoanInfo":"","loan24ContinueOverdue":"","loan24Overdue":"","loan24OverdueCount":"","loanAuditCount":"","openedCount":"","year5CreaditOverdueCount":"","year5LoanOverdueCount":""}],"lbtSerialDetail":[{"accEndNo":"","accMonSer1":"","accMonSer2":"","accMonSer3":"","accMonSer4":"","accMonSer5":"","accMonSer6":"","accMonSer7":"","accType":"","avgMonthIncome":"","cheMonIncome":"466.0","startFromMonthSelect":""}],"lbtSerialInfo":[{"cashRatio":"","cheMonIncome":"3.0","industryProfitRate":"","insteadMonthIncome":"","remark":"","rescindRatio":"","sharesRatio":""}],"retCode":"0000","retMsg":"查询成功！","retTime":"2017-10-14 15:53:00"}
     * retCode : 200
     */

    private String errorDesc;
    private ResponseBodyBean responseBody;
    private String retCode;

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public ResponseBodyBean getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBodyBean responseBody) {
        this.responseBody = responseBody;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public static class ResponseBodyBean {
        /**
         * busiCode : ZYB10
         * interfaceNo : 1010
         * intoInfoList : [{"appProductType":"PTL170600124","auditeState":"1200","cardId":"370501199901019736","cardType":"1","createTime":"1507901582296","custName":"都好久","customerChannel":"6","customerManager":"11050226","customerService":"11050226","fkCustCode":"CR20171001217335","intoAppId":"120153671006","intoInfoStore":"301001205","loanType":"1","manageStore":"301001205","minAppAmount":"466","prodMoneyType":"CNY","prodUrgentRate":"","remark":"好大家大家"}]
         * lbtCustomerBasic : [{"afterTaxMonthlyIncome":"66","cardEndT":"9999-12-31","cardStartT":"2017-10-13","ccurrentAreacode":"","childCount":"","chometownAreacode":"","currentAddr":"新华大街","currentAreacode":"110101","customerSource":"2","email":"djsj@sina.com","famMonPay":"664","hMonPayment":"","hasChild":"0","hasTelephone":"0","hdegree":"","homePartner":"1","homeType":"1","hometownAddr":"都开始看看","hometownAreacode":"110101","inCityYear":"1987","longTerm":"","marrStatus":"1","maxCreditAmount":"66","mobilePhone":"17612237949","nation":"1","pcurrentAreacode":"","phometownAreacode":"","telephoneAreaCode":"","sex":"1","telphone":"17612237949"}]
         * lbtCustomerJob : [{"cjAddrAreacode":"","jAddr":"大家大家","jAddrAreacode":"110101","jDept":"电话","jEnterT":"1507824000000","jMonIncome":"66.0","jMonPayT":"55","jName":"倒计时几","jPayType":"1","jPhone":"222222","jPhoneAreaCode":"222","jPosition":"5","jType":"1","pjAddrAreacode":""}]
         * lbtIntoInfoBankCard : [{"accountName":"在哪开始","bankCardAccount":"12345678911","bankCityAreacode":"110100","bankCode":"102","bankProvAreacode":"110000","bankReservedPhone":"17612237949","isLoanType":"1","isReceiveType":"1","subBranchName":"大家打开"}]
         * lbtIntoInfoBasic : [{"applyPeriod":"3","familyIsKnown":"0","isEms":"0","loanPurpose":"1","loanPurposeDetail":"红红火火恍恍惚惚","monthPayment":"66","prodRepaymentWay":"AC10001","prodServiceRate":"2.45"}]
         * lbtIntoInfoContact : [{"cconHomeAreacode":"","cconJobAreacode":"","conCompany":"还在家睡觉","conHomeAreacode":"110101","conHomeDetailAddr":"睡觉睡觉睡觉","conJobAreacode":"110101","conJobDetailAddr":"都不睡觉","conName":"色即是空开始2","conPhone":"17612237949","conRelation":"0","contactDuty":"","contactType":"3","pconHomeAreacode":"","pconJobAreacode":""},{"cconHomeAreacode":"","cconJobAreacode":"","conCompany":"大家上课","conHomeAreacode":"110101","conHomeDetailAddr":"耍手机","conJobAreacode":"110101","conJobDetailAddr":"死就死","conName":"睡觉的健康","conPhone":"17612237949","conRelation":"0","contactDuty":"","contactType":"3","pconHomeAreacode":"","pconJobAreacode":""},{"cconHomeAreacode":"","cconJobAreacode":"","conCompany":"","conHomeAreacode":"","conHomeDetailAddr":"","conJobAreacode":"","conJobDetailAddr":"","conName":"这就是看看","conPhone":"17612237949","conRelation":"0","contactDuty":"","contactType":"2","pconHomeAreacode":"","pconJobAreacode":""}]
         * lbtIntoInfoHouse : [{"chouseAddrAreacode":"","hPost":"","houseAddrAreacode":"110101","houseBuildArea":"66","houseDetailAddr":"赶紧睡觉大家","houseLoBalance":"","houseLoYearLimit":"33","houseMonthlyPayment":"33.0","housePrice":"55","houseProRightRate":"","housePurchasedYears":"66","houseType":"1","phouseAddrAreacode":""}]
         * lbtIntoInfoInsurPolicy : [{"contractEffectDate":"1507824000000","firstPaymentDate":"1507824000000","insuranceAmount":"664","insurancePeriod":"","insurancePremium":"664","isLifelong":"1","payPeriod":"646.0","paymentMethod":"1"}]
         * lbtIntoInfoManage : [{"comAddr":"1","comEmpCount":"1","comType":"1","houseLoBalance":"","houseMonthlyPayment":"","houseProRightRate":"","registerDate":"1507824000000","shareholdRatio":"66.0"}]
         * lbtIntoInfoUpload : [{"attachId":"B1","attachSize":"400k","attachType":"B1","name":"B1_01.jpg","url":"group1/M00/0A/08/rBJkLVngw2yAH5m8ADOn4ic_6lY324.jpg"},{"attachId":"C1","attachSize":"400k","attachType":"C1","name":"C1_01.jpg","url":"group1/M00/0A/08/rBJkLVngw2yAU4YoADOn4ic_6lY247.jpg"},{"attachId":"A1","attachSize":"400k","attachType":"A1","name":"A1_01.jpg","url":"group1/M00/0A/08/rBJkLVngw2yAAYBnADOn4ic_6lY505.jpg"}]
         * lbtLiability : [{"accCAuditCount":"","accQCount":"3","cardSumDebt":"","credit24ContinueOverdue":"","credit24Overdue":"","credit24OverdueCount":"","creditReportState":"1","creditVersionType":"0","currOverdueAmount":"","debtSum":"","enableCreditCrad":"","incomeDebtRatio":"","isLoanInfo":"","loan24ContinueOverdue":"","loan24Overdue":"","loan24OverdueCount":"","loanAuditCount":"","openedCount":"","year5CreaditOverdueCount":"","year5LoanOverdueCount":""}]
         * lbtSerialDetail : [{"accEndNo":"","accMonSer1":"","accMonSer2":"","accMonSer3":"","accMonSer4":"","accMonSer5":"","accMonSer6":"","accMonSer7":"","accType":"","avgMonthIncome":"","cheMonIncome":"466.0","startFromMonthSelect":""}]
         * lbtSerialInfo : [{"cashRatio":"","cheMonIncome":"3.0","industryProfitRate":"","insteadMonthIncome":"","remark":"","rescindRatio":"","sharesRatio":""}]
         * retCode : 0000
         * retMsg : 查询成功！
         * retTime : 2017-10-14 15:53:00
         */

        private String busiCode;
        private String interfaceNo;
        private String retCode;
        private String retMsg;
        private String retTime;
        private List<IntoInfoListBean> intoInfoList;
        private List<LbtCustomerBasicBean> lbtCustomerBasic;
        private List<LbtCustomerJobBean> lbtCustomerJob;
        private List<LbtIntoInfoBankCardBean> lbtIntoInfoBankCard;
        private List<LbtIntoInfoBasicBean> lbtIntoInfoBasic;
        private List<LbtIntoInfoContactBean> lbtIntoInfoContact;
        private List<LbtIntoInfoHouseBean> lbtIntoInfoHouse;
        private List<LbtIntoInfoInsurPolicyBean> lbtIntoInfoInsurPolicy;
        private List<LbtIntoInfoManageBean> lbtIntoInfoManage;
        private List<LbtIntoInfoUploadBean> lbtIntoInfoUpload;
        private List<LbtLiabilityBean> lbtLiability;
        private List<LbtSerialDetailBean> lbtSerialDetail;
        private List<LbtSerialInfoBean> lbtSerialInfo;

        public String getBusiCode() {
            return busiCode;
        }

        public void setBusiCode(String busiCode) {
            this.busiCode = busiCode;
        }

        public String getInterfaceNo() {
            return interfaceNo;
        }

        public void setInterfaceNo(String interfaceNo) {
            this.interfaceNo = interfaceNo;
        }

        public String getRetCode() {
            return retCode;
        }

        public void setRetCode(String retCode) {
            this.retCode = retCode;
        }

        public String getRetMsg() {
            return retMsg;
        }

        public void setRetMsg(String retMsg) {
            this.retMsg = retMsg;
        }

        public String getRetTime() {
            return retTime;
        }

        public void setRetTime(String retTime) {
            this.retTime = retTime;
        }

        public List<IntoInfoListBean> getIntoInfoList() {
            return intoInfoList;
        }

        public void setIntoInfoList(List<IntoInfoListBean> intoInfoList) {
            this.intoInfoList = intoInfoList;
        }

        public List<LbtCustomerBasicBean> getLbtCustomerBasic() {
            return lbtCustomerBasic;
        }

        public void setLbtCustomerBasic(List<LbtCustomerBasicBean> lbtCustomerBasic) {
            this.lbtCustomerBasic = lbtCustomerBasic;
        }

        public List<LbtCustomerJobBean> getLbtCustomerJob() {
            return lbtCustomerJob;
        }

        public void setLbtCustomerJob(List<LbtCustomerJobBean> lbtCustomerJob) {
            this.lbtCustomerJob = lbtCustomerJob;
        }

        public List<LbtIntoInfoBankCardBean> getLbtIntoInfoBankCard() {
            return lbtIntoInfoBankCard;
        }

        public void setLbtIntoInfoBankCard(List<LbtIntoInfoBankCardBean> lbtIntoInfoBankCard) {
            this.lbtIntoInfoBankCard = lbtIntoInfoBankCard;
        }

        public List<LbtIntoInfoBasicBean> getLbtIntoInfoBasic() {
            return lbtIntoInfoBasic;
        }

        public void setLbtIntoInfoBasic(List<LbtIntoInfoBasicBean> lbtIntoInfoBasic) {
            this.lbtIntoInfoBasic = lbtIntoInfoBasic;
        }

        public List<LbtIntoInfoContactBean> getLbtIntoInfoContact() {
            return lbtIntoInfoContact;
        }

        public void setLbtIntoInfoContact(List<LbtIntoInfoContactBean> lbtIntoInfoContact) {
            this.lbtIntoInfoContact = lbtIntoInfoContact;
        }

        public List<LbtIntoInfoHouseBean> getLbtIntoInfoHouse() {
            return lbtIntoInfoHouse;
        }

        public void setLbtIntoInfoHouse(List<LbtIntoInfoHouseBean> lbtIntoInfoHouse) {
            this.lbtIntoInfoHouse = lbtIntoInfoHouse;
        }

        public List<LbtIntoInfoInsurPolicyBean> getLbtIntoInfoInsurPolicy() {
            return lbtIntoInfoInsurPolicy;
        }

        public void setLbtIntoInfoInsurPolicy(List<LbtIntoInfoInsurPolicyBean> lbtIntoInfoInsurPolicy) {
            this.lbtIntoInfoInsurPolicy = lbtIntoInfoInsurPolicy;
        }

        public List<LbtIntoInfoManageBean> getLbtIntoInfoManage() {
            return lbtIntoInfoManage;
        }

        public void setLbtIntoInfoManage(List<LbtIntoInfoManageBean> lbtIntoInfoManage) {
            this.lbtIntoInfoManage = lbtIntoInfoManage;
        }

        public List<LbtIntoInfoUploadBean> getLbtIntoInfoUpload() {
            return lbtIntoInfoUpload;
        }

        public void setLbtIntoInfoUpload(List<LbtIntoInfoUploadBean> lbtIntoInfoUpload) {
            this.lbtIntoInfoUpload = lbtIntoInfoUpload;
        }

        public List<LbtLiabilityBean> getLbtLiability() {
            return lbtLiability;
        }

        public void setLbtLiability(List<LbtLiabilityBean> lbtLiability) {
            this.lbtLiability = lbtLiability;
        }

        public List<LbtSerialDetailBean> getLbtSerialDetail() {
            return lbtSerialDetail;
        }

        public void setLbtSerialDetail(List<LbtSerialDetailBean> lbtSerialDetail) {
            this.lbtSerialDetail = lbtSerialDetail;
        }

        public List<LbtSerialInfoBean> getLbtSerialInfo() {
            return lbtSerialInfo;
        }

        public void setLbtSerialInfo(List<LbtSerialInfoBean> lbtSerialInfo) {
            this.lbtSerialInfo = lbtSerialInfo;
        }

        public static class IntoInfoListBean {
            /**
             * appProductType : PTL170600124
             * auditeState : 1200
             * cardId : 370501199901019736
             * cardType : 1
             * createTime : 1507901582296
             * custName : 都好久
             * customerChannel : 6
             * customerManager : 11050226
             * customerService : 11050226
             * fkCustCode : CR20171001217335
             * intoAppId : 120153671006
             * intoInfoStore : 301001205
             * loanType : 1
             * manageStore : 301001205
             * minAppAmount : 466
             * prodMoneyType : CNY
             * prodUrgentRate :
             * remark : 好大家大家
             */

            private String appProductType;
            private String auditeState;
            private String cardId;
            private String cardType;
            private String createTime;
            private String custName;
            private String customerChannel;
            private String customerManager;
            private String customerService;
            private String fkCustCode;
            private String intoAppId;
            private String intoInfoStore;
            private String loanType;
            private String manageStore;
            private String minAppAmount;
            private String prodMoneyType;
            private String prodUrgentRate;
            private String remark;

            public String getAppProductType() {
                return appProductType;
            }

            public void setAppProductType(String appProductType) {
                this.appProductType = appProductType;
            }

            public String getAuditeState() {
                return auditeState;
            }

            public void setAuditeState(String auditeState) {
                this.auditeState = auditeState;
            }

            public String getCardId() {
                return cardId;
            }

            public void setCardId(String cardId) {
                this.cardId = cardId;
            }

            public String getCardType() {
                return cardType;
            }

            public void setCardType(String cardType) {
                this.cardType = cardType;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCustName() {
                return custName;
            }

            public void setCustName(String custName) {
                this.custName = custName;
            }

            public String getCustomerChannel() {
                return customerChannel;
            }

            public void setCustomerChannel(String customerChannel) {
                this.customerChannel = customerChannel;
            }

            public String getCustomerManager() {
                return customerManager;
            }

            public void setCustomerManager(String customerManager) {
                this.customerManager = customerManager;
            }

            public String getCustomerService() {
                return customerService;
            }

            public void setCustomerService(String customerService) {
                this.customerService = customerService;
            }

            public String getFkCustCode() {
                return fkCustCode;
            }

            public void setFkCustCode(String fkCustCode) {
                this.fkCustCode = fkCustCode;
            }

            public String getIntoAppId() {
                return intoAppId;
            }

            public void setIntoAppId(String intoAppId) {
                this.intoAppId = intoAppId;
            }

            public String getIntoInfoStore() {
                return intoInfoStore;
            }

            public void setIntoInfoStore(String intoInfoStore) {
                this.intoInfoStore = intoInfoStore;
            }

            public String getLoanType() {
                return loanType;
            }

            public void setLoanType(String loanType) {
                this.loanType = loanType;
            }

            public String getManageStore() {
                return manageStore;
            }

            public void setManageStore(String manageStore) {
                this.manageStore = manageStore;
            }

            public String getMinAppAmount() {
                return minAppAmount;
            }

            public void setMinAppAmount(String minAppAmount) {
                this.minAppAmount = minAppAmount;
            }

            public String getProdMoneyType() {
                return prodMoneyType;
            }

            public void setProdMoneyType(String prodMoneyType) {
                this.prodMoneyType = prodMoneyType;
            }

            public String getProdUrgentRate() {
                return prodUrgentRate;
            }

            public void setProdUrgentRate(String prodUrgentRate) {
                this.prodUrgentRate = prodUrgentRate;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }

        public static class LbtCustomerBasicBean {
            /**
             * afterTaxMonthlyIncome : 66
             * cardEndT : 9999-12-31
             * cardStartT : 2017-10-13
             * ccurrentAreacode :
             * childCount :
             * chometownAreacode :
             * currentAddr : 新华大街
             * currentAreacode : 110101
             * customerSource : 2
             * email : djsj@sina.com
             * famMonPay : 664
             * hMonPayment :
             * hasChild : 0
             * hasTelephone : 0
             * hdegree :
             * homePartner : 1
             * homeType : 1
             * hometownAddr : 都开始看看
             * hometownAreacode : 110101
             * inCityYear : 1987
             * longTerm :
             * marrStatus : 1
             * maxCreditAmount : 66
             * mobilePhone : 17612237949
             * nation : 1
             * pcurrentAreacode :
             * phometownAreacode :
             * telephoneAreaCode :
             * sex : 1
             * telphone : 17612237949
             */

            private String afterTaxMonthlyIncome;
            private String cardEndT;
            private String cardStartT;
            private String ccurrentAreacode;
            private String childCount;
            private String chometownAreacode;
            private String currentAddr;
            private String currentAreacode;
            private String customerSource;
            private String email;
            private String famMonPay;
            private String hMonPayment;
            private String hasChild;
            private String hasTelephone;
            private String hdegree;
            private String homePartner;
            private String homeType;
            private String hometownAddr;
            private String hometownAreacode;
            private String inCityYear;
            private String longTerm;
            private String marrStatus;
            private String maxCreditAmount;
            private String mobilePhone;
            private String nation;
            private String pcurrentAreacode;
            private String phometownAreacode;
            private String telephoneAreaCode;
            private String sex;
            private String telphone;

            public String getAfterTaxMonthlyIncome() {
                return afterTaxMonthlyIncome;
            }

            public void setAfterTaxMonthlyIncome(String afterTaxMonthlyIncome) {
                this.afterTaxMonthlyIncome = afterTaxMonthlyIncome;
            }

            public String getCardEndT() {
                return cardEndT;
            }

            public void setCardEndT(String cardEndT) {
                this.cardEndT = cardEndT;
            }

            public String getCardStartT() {
                return cardStartT;
            }

            public void setCardStartT(String cardStartT) {
                this.cardStartT = cardStartT;
            }

            public String getCcurrentAreacode() {
                return ccurrentAreacode;
            }

            public void setCcurrentAreacode(String ccurrentAreacode) {
                this.ccurrentAreacode = ccurrentAreacode;
            }

            public String getChildCount() {
                return childCount;
            }

            public void setChildCount(String childCount) {
                this.childCount = childCount;
            }

            public String getChometownAreacode() {
                return chometownAreacode;
            }

            public void setChometownAreacode(String chometownAreacode) {
                this.chometownAreacode = chometownAreacode;
            }

            public String getCurrentAddr() {
                return currentAddr;
            }

            public void setCurrentAddr(String currentAddr) {
                this.currentAddr = currentAddr;
            }

            public String getCurrentAreacode() {
                return currentAreacode;
            }

            public void setCurrentAreacode(String currentAreacode) {
                this.currentAreacode = currentAreacode;
            }

            public String getCustomerSource() {
                return customerSource;
            }

            public void setCustomerSource(String customerSource) {
                this.customerSource = customerSource;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getFamMonPay() {
                return famMonPay;
            }

            public void setFamMonPay(String famMonPay) {
                this.famMonPay = famMonPay;
            }

            public String getHMonPayment() {
                return hMonPayment;
            }

            public void setHMonPayment(String hMonPayment) {
                this.hMonPayment = hMonPayment;
            }

            public String getHasChild() {
                return hasChild;
            }

            public void setHasChild(String hasChild) {
                this.hasChild = hasChild;
            }

            public String getHasTelephone() {
                return hasTelephone;
            }

            public void setHasTelephone(String hasTelephone) {
                this.hasTelephone = hasTelephone;
            }

            public String getHdegree() {
                return hdegree;
            }

            public void setHdegree(String hdegree) {
                this.hdegree = hdegree;
            }

            public String getHomePartner() {
                return homePartner;
            }

            public void setHomePartner(String homePartner) {
                this.homePartner = homePartner;
            }

            public String getHomeType() {
                return homeType;
            }

            public void setHomeType(String homeType) {
                this.homeType = homeType;
            }

            public String getHometownAddr() {
                return hometownAddr;
            }

            public void setHometownAddr(String hometownAddr) {
                this.hometownAddr = hometownAddr;
            }

            public String getHometownAreacode() {
                return hometownAreacode;
            }

            public void setHometownAreacode(String hometownAreacode) {
                this.hometownAreacode = hometownAreacode;
            }

            public String getInCityYear() {
                return inCityYear;
            }

            public void setInCityYear(String inCityYear) {
                this.inCityYear = inCityYear;
            }

            public String getLongTerm() {
                return longTerm;
            }

            public void setLongTerm(String longTerm) {
                this.longTerm = longTerm;
            }

            public String getMarrStatus() {
                return marrStatus;
            }

            public void setMarrStatus(String marrStatus) {
                this.marrStatus = marrStatus;
            }

            public String getMaxCreditAmount() {
                return maxCreditAmount;
            }

            public void setMaxCreditAmount(String maxCreditAmount) {
                this.maxCreditAmount = maxCreditAmount;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public String getPcurrentAreacode() {
                return pcurrentAreacode;
            }

            public void setPcurrentAreacode(String pcurrentAreacode) {
                this.pcurrentAreacode = pcurrentAreacode;
            }

            public String getPhometownAreacode() {
                return phometownAreacode;
            }

            public void setPhometownAreacode(String phometownAreacode) {
                this.phometownAreacode = phometownAreacode;
            }

            public String getTelephoneAreaCode() {
                return telephoneAreaCode;
            }

            public void setTelephoneAreaCode(String telephoneAreaCode) {
                this.telephoneAreaCode = telephoneAreaCode;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getTelphone() {
                return telphone;
            }

            public void setTelphone(String telphone) {
                this.telphone = telphone;
            }
        }

        public static class LbtCustomerJobBean {
            /**
             * cjAddrAreacode :
             * jAddr : 大家大家
             * jAddrAreacode : 110101
             * jDept : 电话
             * jEnterT : 1507824000000
             * jMonIncome : 66.0
             * jMonPayT : 55
             * jName : 倒计时几
             * jPayType : 1
             * jPhone : 222222
             * jPhoneAreaCode : 222
             * jPosition : 5
             * jType : 1
             * pjAddrAreacode :
             */

            private String cjAddrAreacode;
            private String jAddr;
            private String jAddrAreacode;
            private String jDept;
            private String jEnterT;
            private String jMonIncome;
            private String jMonPayT;
            private String jName;
            private String jPayType;
            private String jPhone;
            private String jPhoneAreaCode;
            private String jPosition;
            private String jType;
            private String pjAddrAreacode;

            public String getCjAddrAreacode() {
                return cjAddrAreacode;
            }

            public void setCjAddrAreacode(String cjAddrAreacode) {
                this.cjAddrAreacode = cjAddrAreacode;
            }

            public String getJAddr() {
                return jAddr;
            }

            public void setJAddr(String jAddr) {
                this.jAddr = jAddr;
            }

            public String getJAddrAreacode() {
                return jAddrAreacode;
            }

            public void setJAddrAreacode(String jAddrAreacode) {
                this.jAddrAreacode = jAddrAreacode;
            }

            public String getJDept() {
                return jDept;
            }

            public void setJDept(String jDept) {
                this.jDept = jDept;
            }

            public String getJEnterT() {
                return jEnterT;
            }

            public void setJEnterT(String jEnterT) {
                this.jEnterT = jEnterT;
            }

            public String getJMonIncome() {
                return jMonIncome;
            }

            public void setJMonIncome(String jMonIncome) {
                this.jMonIncome = jMonIncome;
            }

            public String getJMonPayT() {
                return jMonPayT;
            }

            public void setJMonPayT(String jMonPayT) {
                this.jMonPayT = jMonPayT;
            }

            public String getJName() {
                return jName;
            }

            public void setJName(String jName) {
                this.jName = jName;
            }

            public String getJPayType() {
                return jPayType;
            }

            public void setJPayType(String jPayType) {
                this.jPayType = jPayType;
            }

            public String getJPhone() {
                return jPhone;
            }

            public void setJPhone(String jPhone) {
                this.jPhone = jPhone;
            }

            public String getJPhoneAreaCode() {
                return jPhoneAreaCode;
            }

            public void setJPhoneAreaCode(String jPhoneAreaCode) {
                this.jPhoneAreaCode = jPhoneAreaCode;
            }

            public String getJPosition() {
                return jPosition;
            }

            public void setJPosition(String jPosition) {
                this.jPosition = jPosition;
            }

            public String getJType() {
                return jType;
            }

            public void setJType(String jType) {
                this.jType = jType;
            }

            public String getPjAddrAreacode() {
                return pjAddrAreacode;
            }

            public void setPjAddrAreacode(String pjAddrAreacode) {
                this.pjAddrAreacode = pjAddrAreacode;
            }
        }

        public static class LbtIntoInfoBankCardBean {
            /**
             * accountName : 在哪开始
             * bankCardAccount : 12345678911
             * bankCityAreacode : 110100
             * bankCode : 102
             * bankProvAreacode : 110000
             * bankReservedPhone : 17612237949
             * isLoanType : 1
             * isReceiveType : 1
             * subBranchName : 大家打开
             */

            private String accountName;
            private String bankCardAccount;
            private String bankCityAreacode;
            private String bankCode;
            private String bankProvAreacode;
            private String bankReservedPhone;
            private String isLoanType;
            private String isReceiveType;
            private String subBranchName;

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getBankCardAccount() {
                return bankCardAccount;
            }

            public void setBankCardAccount(String bankCardAccount) {
                this.bankCardAccount = bankCardAccount;
            }

            public String getBankCityAreacode() {
                return bankCityAreacode;
            }

            public void setBankCityAreacode(String bankCityAreacode) {
                this.bankCityAreacode = bankCityAreacode;
            }

            public String getBankCode() {
                return bankCode;
            }

            public void setBankCode(String bankCode) {
                this.bankCode = bankCode;
            }

            public String getBankProvAreacode() {
                return bankProvAreacode;
            }

            public void setBankProvAreacode(String bankProvAreacode) {
                this.bankProvAreacode = bankProvAreacode;
            }

            public String getBankReservedPhone() {
                return bankReservedPhone;
            }

            public void setBankReservedPhone(String bankReservedPhone) {
                this.bankReservedPhone = bankReservedPhone;
            }

            public String getIsLoanType() {
                return isLoanType;
            }

            public void setIsLoanType(String isLoanType) {
                this.isLoanType = isLoanType;
            }

            public String getIsReceiveType() {
                return isReceiveType;
            }

            public void setIsReceiveType(String isReceiveType) {
                this.isReceiveType = isReceiveType;
            }

            public String getSubBranchName() {
                return subBranchName;
            }

            public void setSubBranchName(String subBranchName) {
                this.subBranchName = subBranchName;
            }
        }

        public static class LbtIntoInfoBasicBean {
            /**
             * applyPeriod : 3
             * familyIsKnown : 0
             * isEms : 0
             * loanPurpose : 1
             * loanPurposeDetail : 红红火火恍恍惚惚
             * monthPayment : 66
             * prodRepaymentWay : AC10001
             * prodServiceRate : 2.45
             */

            private String applyPeriod;
            private String familyIsKnown;
            private String isEms;
            private String loanPurpose;
            private String loanPurposeDetail;
            private String monthPayment;
            private String prodRepaymentWay;
            private String prodServiceRate;

            public String getApplyPeriod() {
                return applyPeriod;
            }

            public void setApplyPeriod(String applyPeriod) {
                this.applyPeriod = applyPeriod;
            }

            public String getFamilyIsKnown() {
                return familyIsKnown;
            }

            public void setFamilyIsKnown(String familyIsKnown) {
                this.familyIsKnown = familyIsKnown;
            }

            public String getIsEms() {
                return isEms;
            }

            public void setIsEms(String isEms) {
                this.isEms = isEms;
            }

            public String getLoanPurpose() {
                return loanPurpose;
            }

            public void setLoanPurpose(String loanPurpose) {
                this.loanPurpose = loanPurpose;
            }

            public String getLoanPurposeDetail() {
                return loanPurposeDetail;
            }

            public void setLoanPurposeDetail(String loanPurposeDetail) {
                this.loanPurposeDetail = loanPurposeDetail;
            }

            public String getMonthPayment() {
                return monthPayment;
            }

            public void setMonthPayment(String monthPayment) {
                this.monthPayment = monthPayment;
            }

            public String getProdRepaymentWay() {
                return prodRepaymentWay;
            }

            public void setProdRepaymentWay(String prodRepaymentWay) {
                this.prodRepaymentWay = prodRepaymentWay;
            }

            public String getProdServiceRate() {
                return prodServiceRate;
            }

            public void setProdServiceRate(String prodServiceRate) {
                this.prodServiceRate = prodServiceRate;
            }
        }

        public static class LbtIntoInfoContactBean {
            /**
             * cconHomeAreacode :
             * cconJobAreacode :
             * conCompany : 还在家睡觉
             * conHomeAreacode : 110101
             * conHomeDetailAddr : 睡觉睡觉睡觉
             * conJobAreacode : 110101
             * conJobDetailAddr : 都不睡觉
             * conName : 色即是空开始2
             * conPhone : 17612237949
             * conRelation : 0
             * contactDuty :
             * contactType : 3
             * pconHomeAreacode :
             * pconJobAreacode :
             */

            private String cconHomeAreacode;
            private String cconJobAreacode;
            private String conCompany;
            private String conHomeAreacode;
            private String conHomeDetailAddr;
            private String conJobAreacode;
            private String conJobDetailAddr;
            private String conName;
            private String conPhone;
            private String conRelation;
            private String contactDuty;
            private String contactType;
            private String pconHomeAreacode;
            private String pconJobAreacode;

            public String getCconHomeAreacode() {
                return cconHomeAreacode;
            }

            public void setCconHomeAreacode(String cconHomeAreacode) {
                this.cconHomeAreacode = cconHomeAreacode;
            }

            public String getCconJobAreacode() {
                return cconJobAreacode;
            }

            public void setCconJobAreacode(String cconJobAreacode) {
                this.cconJobAreacode = cconJobAreacode;
            }

            public String getConCompany() {
                return conCompany;
            }

            public void setConCompany(String conCompany) {
                this.conCompany = conCompany;
            }

            public String getConHomeAreacode() {
                return conHomeAreacode;
            }

            public void setConHomeAreacode(String conHomeAreacode) {
                this.conHomeAreacode = conHomeAreacode;
            }

            public String getConHomeDetailAddr() {
                return conHomeDetailAddr;
            }

            public void setConHomeDetailAddr(String conHomeDetailAddr) {
                this.conHomeDetailAddr = conHomeDetailAddr;
            }

            public String getConJobAreacode() {
                return conJobAreacode;
            }

            public void setConJobAreacode(String conJobAreacode) {
                this.conJobAreacode = conJobAreacode;
            }

            public String getConJobDetailAddr() {
                return conJobDetailAddr;
            }

            public void setConJobDetailAddr(String conJobDetailAddr) {
                this.conJobDetailAddr = conJobDetailAddr;
            }

            public String getConName() {
                return conName;
            }

            public void setConName(String conName) {
                this.conName = conName;
            }

            public String getConPhone() {
                return conPhone;
            }

            public void setConPhone(String conPhone) {
                this.conPhone = conPhone;
            }

            public String getConRelation() {
                return conRelation;
            }

            public void setConRelation(String conRelation) {
                this.conRelation = conRelation;
            }

            public String getContactDuty() {
                return contactDuty;
            }

            public void setContactDuty(String contactDuty) {
                this.contactDuty = contactDuty;
            }

            public String getContactType() {
                return contactType;
            }

            public void setContactType(String contactType) {
                this.contactType = contactType;
            }

            public String getPconHomeAreacode() {
                return pconHomeAreacode;
            }

            public void setPconHomeAreacode(String pconHomeAreacode) {
                this.pconHomeAreacode = pconHomeAreacode;
            }

            public String getPconJobAreacode() {
                return pconJobAreacode;
            }

            public void setPconJobAreacode(String pconJobAreacode) {
                this.pconJobAreacode = pconJobAreacode;
            }
        }

        public static class LbtIntoInfoHouseBean {
            /**
             * chouseAddrAreacode :
             * hPost :
             * houseAddrAreacode : 110101
             * houseBuildArea : 66
             * houseDetailAddr : 赶紧睡觉大家
             * houseLoBalance :
             * houseLoYearLimit : 33
             * houseMonthlyPayment : 33.0
             * housePrice : 55
             * houseProRightRate :
             * housePurchasedYears : 66
             * houseType : 1
             * phouseAddrAreacode :
             */

            private String chouseAddrAreacode;
            private String hPost;
            private String houseAddrAreacode;
            private String houseBuildArea;
            private String houseDetailAddr;
            private String houseLoBalance;
            private String houseLoYearLimit;
            private String houseMonthlyPayment;
            private String housePrice;
            private String houseProRightRate;
            private String housePurchasedYears;
            private String houseType;
            private String phouseAddrAreacode;

            public String getChouseAddrAreacode() {
                return chouseAddrAreacode;
            }

            public void setChouseAddrAreacode(String chouseAddrAreacode) {
                this.chouseAddrAreacode = chouseAddrAreacode;
            }

            public String getHPost() {
                return hPost;
            }

            public void setHPost(String hPost) {
                this.hPost = hPost;
            }

            public String getHouseAddrAreacode() {
                return houseAddrAreacode;
            }

            public void setHouseAddrAreacode(String houseAddrAreacode) {
                this.houseAddrAreacode = houseAddrAreacode;
            }

            public String getHouseBuildArea() {
                return houseBuildArea;
            }

            public void setHouseBuildArea(String houseBuildArea) {
                this.houseBuildArea = houseBuildArea;
            }

            public String getHouseDetailAddr() {
                return houseDetailAddr;
            }

            public void setHouseDetailAddr(String houseDetailAddr) {
                this.houseDetailAddr = houseDetailAddr;
            }

            public String getHouseLoBalance() {
                return houseLoBalance;
            }

            public void setHouseLoBalance(String houseLoBalance) {
                this.houseLoBalance = houseLoBalance;
            }

            public String getHouseLoYearLimit() {
                return houseLoYearLimit;
            }

            public void setHouseLoYearLimit(String houseLoYearLimit) {
                this.houseLoYearLimit = houseLoYearLimit;
            }

            public String getHouseMonthlyPayment() {
                return houseMonthlyPayment;
            }

            public void setHouseMonthlyPayment(String houseMonthlyPayment) {
                this.houseMonthlyPayment = houseMonthlyPayment;
            }

            public String getHousePrice() {
                return housePrice;
            }

            public void setHousePrice(String housePrice) {
                this.housePrice = housePrice;
            }

            public String getHouseProRightRate() {
                return houseProRightRate;
            }

            public void setHouseProRightRate(String houseProRightRate) {
                this.houseProRightRate = houseProRightRate;
            }

            public String getHousePurchasedYears() {
                return housePurchasedYears;
            }

            public void setHousePurchasedYears(String housePurchasedYears) {
                this.housePurchasedYears = housePurchasedYears;
            }

            public String getHouseType() {
                return houseType;
            }

            public void setHouseType(String houseType) {
                this.houseType = houseType;
            }

            public String getPhouseAddrAreacode() {
                return phouseAddrAreacode;
            }

            public void setPhouseAddrAreacode(String phouseAddrAreacode) {
                this.phouseAddrAreacode = phouseAddrAreacode;
            }
        }

        public static class LbtIntoInfoInsurPolicyBean {
            /**
             * contractEffectDate : 1507824000000
             * firstPaymentDate : 1507824000000
             * insuranceAmount : 664
             * insurancePeriod :
             * insurancePremium : 664
             * isLifelong : 1
             * payPeriod : 646.0
             * paymentMethod : 1
             */

            private String contractEffectDate;
            private String firstPaymentDate;
            private String insuranceAmount;
            private String insurancePeriod;
            private String insurancePremium;
            private String isLifelong;
            private String payPeriod;
            private String paymentMethod;

            public String getContractEffectDate() {
                return contractEffectDate;
            }

            public void setContractEffectDate(String contractEffectDate) {
                this.contractEffectDate = contractEffectDate;
            }

            public String getFirstPaymentDate() {
                return firstPaymentDate;
            }

            public void setFirstPaymentDate(String firstPaymentDate) {
                this.firstPaymentDate = firstPaymentDate;
            }

            public String getInsuranceAmount() {
                return insuranceAmount;
            }

            public void setInsuranceAmount(String insuranceAmount) {
                this.insuranceAmount = insuranceAmount;
            }

            public String getInsurancePeriod() {
                return insurancePeriod;
            }

            public void setInsurancePeriod(String insurancePeriod) {
                this.insurancePeriod = insurancePeriod;
            }

            public String getInsurancePremium() {
                return insurancePremium;
            }

            public void setInsurancePremium(String insurancePremium) {
                this.insurancePremium = insurancePremium;
            }

            public String getIsLifelong() {
                return isLifelong;
            }

            public void setIsLifelong(String isLifelong) {
                this.isLifelong = isLifelong;
            }

            public String getPayPeriod() {
                return payPeriod;
            }

            public void setPayPeriod(String payPeriod) {
                this.payPeriod = payPeriod;
            }

            public String getPaymentMethod() {
                return paymentMethod;
            }

            public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
            }
        }

        public static class LbtIntoInfoManageBean {
            /**
             * comAddr : 1
             * comEmpCount : 1
             * comType : 1
             * houseLoBalance :
             * houseMonthlyPayment :
             * houseProRightRate :
             * registerDate : 1507824000000
             * shareholdRatio : 66.0
             */

            private String comAddr;
            private String comEmpCount;
            private String comType;
            private String houseLoBalance;
            private String houseMonthlyPayment;
            private String houseProRightRate;
            private String registerDate;
            private String shareholdRatio;

            public String getComAddr() {
                return comAddr;
            }

            public void setComAddr(String comAddr) {
                this.comAddr = comAddr;
            }

            public String getComEmpCount() {
                return comEmpCount;
            }

            public void setComEmpCount(String comEmpCount) {
                this.comEmpCount = comEmpCount;
            }

            public String getComType() {
                return comType;
            }

            public void setComType(String comType) {
                this.comType = comType;
            }

            public String getHouseLoBalance() {
                return houseLoBalance;
            }

            public void setHouseLoBalance(String houseLoBalance) {
                this.houseLoBalance = houseLoBalance;
            }

            public String getHouseMonthlyPayment() {
                return houseMonthlyPayment;
            }

            public void setHouseMonthlyPayment(String houseMonthlyPayment) {
                this.houseMonthlyPayment = houseMonthlyPayment;
            }

            public String getHouseProRightRate() {
                return houseProRightRate;
            }

            public void setHouseProRightRate(String houseProRightRate) {
                this.houseProRightRate = houseProRightRate;
            }

            public String getRegisterDate() {
                return registerDate;
            }

            public void setRegisterDate(String registerDate) {
                this.registerDate = registerDate;
            }

            public String getShareholdRatio() {
                return shareholdRatio;
            }

            public void setShareholdRatio(String shareholdRatio) {
                this.shareholdRatio = shareholdRatio;
            }
        }

        public static class LbtIntoInfoUploadBean {
            /**
             * attachId : B1
             * attachSize : 400k
             * attachType : B1
             * name : B1_01.jpg
             * url : group1/M00/0A/08/rBJkLVngw2yAH5m8ADOn4ic_6lY324.jpg
             */

            private String attachId;
            private String attachSize;
            private String attachType;
            private String name;
            private String url;

            public String getAttachId() {
                return attachId;
            }

            public void setAttachId(String attachId) {
                this.attachId = attachId;
            }

            public String getAttachSize() {
                return attachSize;
            }

            public void setAttachSize(String attachSize) {
                this.attachSize = attachSize;
            }

            public String getAttachType() {
                return attachType;
            }

            public void setAttachType(String attachType) {
                this.attachType = attachType;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class LbtLiabilityBean {
            /**
             * accCAuditCount :
             * accQCount : 3
             * cardSumDebt :
             * credit24ContinueOverdue :
             * credit24Overdue :
             * credit24OverdueCount :
             * creditReportState : 1
             * creditVersionType : 0
             * currOverdueAmount :
             * debtSum :
             * enableCreditCrad :
             * incomeDebtRatio :
             * isLoanInfo :
             * loan24ContinueOverdue :
             * loan24Overdue :
             * loan24OverdueCount :
             * loanAuditCount :
             * openedCount :
             * year5CreaditOverdueCount :
             * year5LoanOverdueCount :
             */

            private String accCAuditCount;
            private String accQCount;
            private String cardSumDebt;
            private String credit24ContinueOverdue;
            private String credit24Overdue;
            private String credit24OverdueCount;
            private String creditReportState;
            private String creditVersionType;
            private String currOverdueAmount;
            private String debtSum;
            private String enableCreditCrad;
            private String incomeDebtRatio;
            private String isLoanInfo;
            private String loan24ContinueOverdue;
            private String loan24Overdue;
            private String loan24OverdueCount;
            private String loanAuditCount;
            private String openedCount;
            private String year5CreaditOverdueCount;
            private String year5LoanOverdueCount;

            public String getAccCAuditCount() {
                return accCAuditCount;
            }

            public void setAccCAuditCount(String accCAuditCount) {
                this.accCAuditCount = accCAuditCount;
            }

            public String getAccQCount() {
                return accQCount;
            }

            public void setAccQCount(String accQCount) {
                this.accQCount = accQCount;
            }

            public String getCardSumDebt() {
                return cardSumDebt;
            }

            public void setCardSumDebt(String cardSumDebt) {
                this.cardSumDebt = cardSumDebt;
            }

            public String getCredit24ContinueOverdue() {
                return credit24ContinueOverdue;
            }

            public void setCredit24ContinueOverdue(String credit24ContinueOverdue) {
                this.credit24ContinueOverdue = credit24ContinueOverdue;
            }

            public String getCredit24Overdue() {
                return credit24Overdue;
            }

            public void setCredit24Overdue(String credit24Overdue) {
                this.credit24Overdue = credit24Overdue;
            }

            public String getCredit24OverdueCount() {
                return credit24OverdueCount;
            }

            public void setCredit24OverdueCount(String credit24OverdueCount) {
                this.credit24OverdueCount = credit24OverdueCount;
            }

            public String getCreditReportState() {
                return creditReportState;
            }

            public void setCreditReportState(String creditReportState) {
                this.creditReportState = creditReportState;
            }

            public String getCreditVersionType() {
                return creditVersionType;
            }

            public void setCreditVersionType(String creditVersionType) {
                this.creditVersionType = creditVersionType;
            }

            public String getCurrOverdueAmount() {
                return currOverdueAmount;
            }

            public void setCurrOverdueAmount(String currOverdueAmount) {
                this.currOverdueAmount = currOverdueAmount;
            }

            public String getDebtSum() {
                return debtSum;
            }

            public void setDebtSum(String debtSum) {
                this.debtSum = debtSum;
            }

            public String getEnableCreditCrad() {
                return enableCreditCrad;
            }

            public void setEnableCreditCrad(String enableCreditCrad) {
                this.enableCreditCrad = enableCreditCrad;
            }

            public String getIncomeDebtRatio() {
                return incomeDebtRatio;
            }

            public void setIncomeDebtRatio(String incomeDebtRatio) {
                this.incomeDebtRatio = incomeDebtRatio;
            }

            public String getIsLoanInfo() {
                return isLoanInfo;
            }

            public void setIsLoanInfo(String isLoanInfo) {
                this.isLoanInfo = isLoanInfo;
            }

            public String getLoan24ContinueOverdue() {
                return loan24ContinueOverdue;
            }

            public void setLoan24ContinueOverdue(String loan24ContinueOverdue) {
                this.loan24ContinueOverdue = loan24ContinueOverdue;
            }

            public String getLoan24Overdue() {
                return loan24Overdue;
            }

            public void setLoan24Overdue(String loan24Overdue) {
                this.loan24Overdue = loan24Overdue;
            }

            public String getLoan24OverdueCount() {
                return loan24OverdueCount;
            }

            public void setLoan24OverdueCount(String loan24OverdueCount) {
                this.loan24OverdueCount = loan24OverdueCount;
            }

            public String getLoanAuditCount() {
                return loanAuditCount;
            }

            public void setLoanAuditCount(String loanAuditCount) {
                this.loanAuditCount = loanAuditCount;
            }

            public String getOpenedCount() {
                return openedCount;
            }

            public void setOpenedCount(String openedCount) {
                this.openedCount = openedCount;
            }

            public String getYear5CreaditOverdueCount() {
                return year5CreaditOverdueCount;
            }

            public void setYear5CreaditOverdueCount(String year5CreaditOverdueCount) {
                this.year5CreaditOverdueCount = year5CreaditOverdueCount;
            }

            public String getYear5LoanOverdueCount() {
                return year5LoanOverdueCount;
            }

            public void setYear5LoanOverdueCount(String year5LoanOverdueCount) {
                this.year5LoanOverdueCount = year5LoanOverdueCount;
            }
        }

        public static class LbtSerialDetailBean {
            /**
             * accEndNo :
             * accMonSer1 :
             * accMonSer2 :
             * accMonSer3 :
             * accMonSer4 :
             * accMonSer5 :
             * accMonSer6 :
             * accMonSer7 :
             * accType :
             * avgMonthIncome :
             * cheMonIncome : 466.0
             * startFromMonthSelect :
             */

            private String accEndNo;
            private String accMonSer1;
            private String accMonSer2;
            private String accMonSer3;
            private String accMonSer4;
            private String accMonSer5;
            private String accMonSer6;
            private String accMonSer7;
            private String accType;
            private String avgMonthIncome;
            private String cheMonIncome;
            private String startFromMonthSelect;

            public String getAccEndNo() {
                return accEndNo;
            }

            public void setAccEndNo(String accEndNo) {
                this.accEndNo = accEndNo;
            }

            public String getAccMonSer1() {
                return accMonSer1;
            }

            public void setAccMonSer1(String accMonSer1) {
                this.accMonSer1 = accMonSer1;
            }

            public String getAccMonSer2() {
                return accMonSer2;
            }

            public void setAccMonSer2(String accMonSer2) {
                this.accMonSer2 = accMonSer2;
            }

            public String getAccMonSer3() {
                return accMonSer3;
            }

            public void setAccMonSer3(String accMonSer3) {
                this.accMonSer3 = accMonSer3;
            }

            public String getAccMonSer4() {
                return accMonSer4;
            }

            public void setAccMonSer4(String accMonSer4) {
                this.accMonSer4 = accMonSer4;
            }

            public String getAccMonSer5() {
                return accMonSer5;
            }

            public void setAccMonSer5(String accMonSer5) {
                this.accMonSer5 = accMonSer5;
            }

            public String getAccMonSer6() {
                return accMonSer6;
            }

            public void setAccMonSer6(String accMonSer6) {
                this.accMonSer6 = accMonSer6;
            }

            public String getAccMonSer7() {
                return accMonSer7;
            }

            public void setAccMonSer7(String accMonSer7) {
                this.accMonSer7 = accMonSer7;
            }

            public String getAccType() {
                return accType;
            }

            public void setAccType(String accType) {
                this.accType = accType;
            }

            public String getAvgMonthIncome() {
                return avgMonthIncome;
            }

            public void setAvgMonthIncome(String avgMonthIncome) {
                this.avgMonthIncome = avgMonthIncome;
            }

            public String getCheMonIncome() {
                return cheMonIncome;
            }

            public void setCheMonIncome(String cheMonIncome) {
                this.cheMonIncome = cheMonIncome;
            }

            public String getStartFromMonthSelect() {
                return startFromMonthSelect;
            }

            public void setStartFromMonthSelect(String startFromMonthSelect) {
                this.startFromMonthSelect = startFromMonthSelect;
            }
        }

        public static class LbtSerialInfoBean {
            /**
             * cashRatio :
             * cheMonIncome : 3.0
             * industryProfitRate :
             * insteadMonthIncome :
             * remark :
             * rescindRatio :
             * sharesRatio :
             */

            private String cashRatio;
            private String cheMonIncome;
            private String industryProfitRate;
            private String insteadMonthIncome;
            private String remark;
            private String rescindRatio;
            private String sharesRatio;

            public String getCashRatio() {
                return cashRatio;
            }

            public void setCashRatio(String cashRatio) {
                this.cashRatio = cashRatio;
            }

            public String getCheMonIncome() {
                return cheMonIncome;
            }

            public void setCheMonIncome(String cheMonIncome) {
                this.cheMonIncome = cheMonIncome;
            }

            public String getIndustryProfitRate() {
                return industryProfitRate;
            }

            public void setIndustryProfitRate(String industryProfitRate) {
                this.industryProfitRate = industryProfitRate;
            }

            public String getInsteadMonthIncome() {
                return insteadMonthIncome;
            }

            public void setInsteadMonthIncome(String insteadMonthIncome) {
                this.insteadMonthIncome = insteadMonthIncome;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getRescindRatio() {
                return rescindRatio;
            }

            public void setRescindRatio(String rescindRatio) {
                this.rescindRatio = rescindRatio;
            }

            public String getSharesRatio() {
                return sharesRatio;
            }

            public void setSharesRatio(String sharesRatio) {
                this.sharesRatio = sharesRatio;
            }
        }
    }
}
