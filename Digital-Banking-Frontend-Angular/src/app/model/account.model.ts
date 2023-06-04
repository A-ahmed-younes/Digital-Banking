export interface AccountDetails {
  id:                   string;
  type:                 string;
  balance:              number;
  createdAt:            string;
  overDraft:            number;
  interestRate:         number;
  currentPage:          number;
  totalPages:           number;
  pageSize:             number;
  accountOperationDTOS: AccountOperation[];
}

export interface AccountOperation {
  id:            number;
  operationDate: Date;
  amount:        number;
  type:          string;
  description:   string;
}
