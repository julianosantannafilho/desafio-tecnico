import { Component } from '@angular/core';
import { MedidasComponent } from './medidas/medidas.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MedidasComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Sistema de Medidas';
}
