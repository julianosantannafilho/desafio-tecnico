import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


interface Medida {
  id?: number;
  nomeMedida: string;
  valorDimensao: number;
  unidadeMedida: string;
}

@Component({
  selector: 'app-medidas',
  standalone: true,
  imports: [CommonModule, FormsModule],  
  templateUrl: './medidas.component.html',
  styleUrls: ['./medidas.component.css']
})
export class MedidasComponent implements OnInit {

  medidas: Medida[] = [];              
  formData: Medida = {                 
    nomeMedida: '',
    valorDimensao: 0,
    unidadeMedida: 'cm'
  };
  loading = false;                     
  error = '';                         
  

  private apiUrl = 'http://localhost:8080/roupas';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };


  constructor(private http: HttpClient) {
    console.log('MedidasComponent inicializado');
  }
  


  ngOnInit(): void {
    console.log('Carregando medidas...');
    this.carregarMedidas();
  }

  carregarMedidas(): void {

    console.log('GET:', `${this.apiUrl}/all`);

    this.http.get<Medida[]>(`${this.apiUrl}/all`).subscribe({
      next: (data) => {
        this.medidas = data;
        this.error = '';
      },
      error: (err) => {

        console.error('Erro completo:', err);

        if (err.status === 404) {
          this.medidas = [];
          this.error = '';
        } else {
          this.error = `Erro ao conectar: ${err.status} - ${err.message}`;
        }
      }
    });
  }


  salvarMedida(): void {

    if (!this.formData.nomeMedida || !this.formData.valorDimensao) {
      this.error = 'Preencha todos os campos';
      return;
    }

    this.loading = true;
    this.error = '';

    console.log('POST:', this.formData);

    this.http.post<Medida>(`${this.apiUrl}/create`, this.formData, this.httpOptions)
      .subscribe({
        next: (response) => {
          console.log('Salvo com sucesso:', response);
          this.formData = {
            nomeMedida: '',
            valorDimensao: 0,
            unidadeMedida: 'cm'
          };
          this.carregarMedidas(); 
          this.loading = false;
        },
        error: (err) => {

          console.error('Erro ao salvar:', err);

          this.error = 'Erro ao salvar medida';
          this.loading = false;
        }
      });
  }

  deletarMedida(id: number | undefined): void {
    if (!id) return;
    
    if (!confirm('Deseja realmente deletar esta medida?')) {
      return;
    }

    this.http.delete(`${this.apiUrl}/${id}`).subscribe({
      next: () => {
        this.carregarMedidas();
      },
      error: (err) => {
        console.error('Erro ao deletar:', err);
        this.error = `Erro ao deletar: ${err.status} - ${err.message}`;
      }
    });
  }
}