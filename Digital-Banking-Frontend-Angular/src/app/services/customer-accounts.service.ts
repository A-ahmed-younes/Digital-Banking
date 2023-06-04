import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {AccountDetails} from "../model/account.model";

@Injectable({
  providedIn: 'root'
})
export class CustomerAccountsService {

  constructor(private http : HttpClient) { }

  public getCustomerAccounts(customerId : number):Observable<Array<AccountDetails>>{
    return this.http.get<Array<AccountDetails>>(environment.backendHost+"/customers/"+customerId+"/accounts");
  }


}
