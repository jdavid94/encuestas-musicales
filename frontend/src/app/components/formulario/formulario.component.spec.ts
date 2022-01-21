import { Component } from "@angular/core";
import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { FormularioService } from "src/app/services/formulario.service";
import { FormularioComponent } from "./formulario.component";
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('FormularioComponent', () => {
        let component: FormularioComponent;
        let fixture: ComponentFixture<FormularioComponent>;

        beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [FormularioComponent],
            imports: [HttpClientTestingModule],
            providers: [FormularioService]
        })
            .compileComponents();
        });

        beforeEach(() => {
            fixture = TestBed.createComponent(FormularioComponent);
            component = fixture.componentInstance;
            fixture.detectChanges();
        });

        it('Es creado', () => {
            expect(component).toBeTruthy();
        });
});
       
