package ipeps.pwd.wallet.module.utils;

import ipeps.pwd.wallet.module.organization.entity.Organization;

public class ApiReponseCode {
                  // pour Account
                   public static String AccountNotFoundErrorCode() {return "api.account.not-found";}
                   public static String AccountDeleteSuccessCode() {return "api.account.delete-success";}

                   // pour Employee
                   public static String AddressNotFoundErrorCode() {return "api.address.not-found";}
                   public static String AddressDeleteSuccessCode() {return "api.address.delete-success";}

                   // pour Employee
                   public static String EmployeeDeleteSuccessCode() {return "api.employee.delete-success";}
                   public static String EmployeeNotFoundErrorCode() {return "api.employee.not-found";}

                   // pour Organization
                   public static String OrganizationDeleteSuccessCode() {return "api.organization.delete-success";}
                   public static String OrganizationNotFoundErrorCode() {return "api.organization.not-found";}
                  // public static String findDocumentByOrganization(organization) { return "api.organization.not-exist";}

                   // pour Salary
                   public static String SalaryDeleteSuccessCode() {return "api.salary.delete-success";}
                   public static String SalaryNotFoundErrorCode() {return "api.salary.not-found";}

                   // pour contact
                   public static String DocumentDeleteSuccessCode() {return "api.document.delete-success";}
                   public static String DocumentNotFoundErrorCode() {return "api.document.not-found";}

                   // pour contact
                   public static String ScheduleDeleteSuccessCode() {return "api.schedule.delete-success";}
                   public static String ScheduleNotFoundErrorCode() {return "api.schedule.not-found";}

                   // pour contact
                  public static String TransactionDeleteSuccessCode() {return "api.transaction.delete-success";}
                  public static String TransactionNotFoundErrorCode() {return "api.transaction.not-found";}

                  // pour contact
                  public static String ContactDeleteSuccessCode() {return "api.contact.delete-success";}
                  public static String ContactNotFoundErrorCode() {return "api.contact.not-found";}

                  // pour contact
                 public static String WalletDeleteSuccessCode() {return "api.wallet.delete-success";}
                 public static String WalletNotFoundErrorCode() {return "api.wallet.not-found";}
}
