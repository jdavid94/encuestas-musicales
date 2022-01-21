import { Component } from "@angular/core";
import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { ListadosComponent } from "./listados.component";
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormularioService } from "src/app/services/formulario.service";

describe('ListadosComponent', () => {
    let component: ListadosComponent;
    let fixture: ComponentFixture<ListadosComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [ListadosComponent],
            imports: [HttpClientTestingModule],
            providers: [FormularioService]
        })
            .compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(ListadosComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('Es creado', () => {
        expect(component).toBeTruthy();
    });    
});