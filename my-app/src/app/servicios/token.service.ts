import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { SesionService } from './sesion.service';
import { AuthService } from './auth.service';
import { UsuarioService } from './usuario.service';
const TOKEN_KEY = 'AuthToken';
const CODIGO_CUENTA = 'CodigoCuenta';
@Injectable({
  providedIn: 'root',
})
export class TokenService {
  constructor(private router: Router,private sesionServicio: SesionService, private authServicio: AuthService, private usuarioServicio: UsuarioService) {}
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
  public login(token: string) {
    this.setToken(token);
    this.usuarioServicio.obtenerUsuariosEmail(this.getEmail()).subscribe({
      next: data => {
        window.sessionStorage.removeItem(CODIGO_CUENTA);
        window.sessionStorage.setItem(CODIGO_CUENTA, data.respuesta.codigoCuenta);
      },
      error: error => {
        console.log(error.error);
      }
    });
    this.sesionServicio.updateSession(true);
    this.router.navigate(['/']);
  }

    public logout() {
      window.sessionStorage.clear();
      this.router.navigate(["/login"]);
      }
      public getCodigoCuenta(): number {
        let codigo = window.sessionStorage.getItem(CODIGO_CUENTA);
        if(codigo != null) {
          return Number.parseInt(codigo);
        }
        return -1;
      }
    
      public getEmail(): string {
        const token = this.getToken();
        if (token) {
          const values = this.decodePayload(token);
          return values.sub;
        }
        return '';
      }
      
      public getRole(): string[] {
        const token = this.getToken();
        if (token) {
          const values = this.decodePayload(token);
          return values.roles;
        }
        return [];
      }

}
