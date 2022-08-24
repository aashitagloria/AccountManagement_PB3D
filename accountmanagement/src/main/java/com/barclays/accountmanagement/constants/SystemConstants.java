package com.barclays.accountmanagement.constants;

public interface SystemConstants {
  public static final String GET_ACCOUNTS_BY_CUSTOMERID = "/accounts/customer/{id}";
  public static final String CREATE_ONLINE_ACCOUNT = "api/manager/create-customer";
  public static final String CREATE_SAVING_ACCOUNT = "api/manager/create-account";
  public static final String VERIFY_PANCARD = "api/manager/verify-pancard";
  public static final String GET_CURRENT_BALANCE="api/transaction/getCurrentBalance/{id}";
  public static final String UPDATE_CURRENT_BALANCE="api/transaction/withdraw/{id}/{amount}";
  public static final String DEPOSIT_MONEY="api/transaction/deposit/{depositID}/{amount}";
  public static final String TRANSFER_MONEY="api/transaction/transfer";
  public static final String CHECK_HISTORY= "api/transaction/recent";
  public static final String GET_TRANSACTION_LIST= "api/transaction/get-transaction/{accountNumber}";
  public static final String GET_TRANSACTION_LIST_BY_DATE= "api/transaction/get-transaction/{accountNumber}/{date}";
  public static final String TRANSACTION_DOWNLOAD_CSV="api/transaction/get-transaction/downloadcsv/{accountNumber}/{date}";
  public static final String VERIFY_USER_CREDENTIAL="api/user/user-login";
  public static final String UPDATE_USER_CREDENTIALS="api/user/update-user-credentials";
}
