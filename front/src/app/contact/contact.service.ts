import { inject, Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of, tap } from 'rxjs';
import { Contact } from './contact.model';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private apiUrl = 'api/contact'; 

  private readonly http = inject(HttpClient);
  private readonly _contact = signal<Contact[]>([]);

  public readonly contact = this._contact.asReadonly();

  sendContactForm(contact: Contact): Observable<any> {
    return this.http.post<boolean>(`${this.apiUrl}/create`, contact).pipe(
        catchError(() => { 
            return of(true);
        })
    );
  }
}