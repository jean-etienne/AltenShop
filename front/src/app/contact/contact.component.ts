import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ContactService } from './contact.service';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [InputTextareaModule, ReactiveFormsModule, ButtonModule, NgIf],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {

  contactForm: FormGroup;
  validationMessage: any;  

  constructor(private fb: FormBuilder, private contactService: ContactService) {
    
      this.contactForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      message: ['', [Validators.required, Validators.maxLength(300)]]
    });
  }

   onSubmit() {
    if (this.contactForm.valid) {
      this.contactService.sendContactForm(this.contactForm.value).subscribe({
        next: (response) => {
          console.log('Formulaire envoyé avec succès!', response);
          this.contactForm.reset();
          this.validationMessage = 'Votre demande a bien été transmise';
        },
        error: (error) => {
          this.validationMessage = 'Il y a eu un probleme lors de votre envoi, veuillez ressayer plus tard';
          console.error('Erreur lors de l\'envoi du formulaire', error);
        }
      });
    }
  }
}
