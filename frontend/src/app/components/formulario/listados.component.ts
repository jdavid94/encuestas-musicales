import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Formulario } from 'src/app/models/formulario';
import { FormularioService } from 'src/app/services/formulario.service';

@Component({
  selector: 'app-listados',
  templateUrl: './listados.component.html',
  styleUrls: ['./listados.component.css']
})
export class ListadosComponent implements OnInit {

  public title: string = 'Listado de Respuestas';
  public formularios: Formulario[] = []; 
  public totalRegistros = 0;
  public paginaActual = 0;
  public totalPorPagina = 4;
  public pageSizeOptions: number[] = [4, 8, 12];

  constructor(private formularioService: FormularioService) { }

  ngOnInit(): void {  
    this.dataPaginator(); 
  }

  public paginator(event: PageEvent): void {
    this.paginaActual = event.pageIndex;
    this.totalRegistros = event.pageSize;
    this.dataPaginator();
  }
  
  private dataPaginator() {
    this.formularioService.listPaginada(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(resp => {
      this.formularios = resp.content as Formulario[];
      this.totalRegistros = resp.totalElements as number;
    })
  }

}
