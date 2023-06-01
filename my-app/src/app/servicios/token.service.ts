import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
const TOKEN_KEY = 'AuthToken';
@Injectable({
  providedIn: 'root',
})
export class TokenService {
  constructor(private router: Router) {}
  public setToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public isLogged(): boolean {
    if (this.getToken()) {
      return true;
    }
    return false;
  }
  private decodePayload(token: string): any {
    const payload = token!.split('.')[1];
    const payloadDecoded = atob(payload);
    const values = JSON.parse(payloadDecoded);
    return values;
  }
  public login(token:string){
    this.setToken(token);
    this.router.navigate(["/"]);
    }

    public logout() {
      window.sessionStorage.clear();
      this.router.navigate(["/login"]);
      }

}
