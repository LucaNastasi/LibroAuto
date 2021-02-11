import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimapaginaComponent } from './primapagina.component';

describe('PrimapaginaComponent', () => {
  let component: PrimapaginaComponent;
  let fixture: ComponentFixture<PrimapaginaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrimapaginaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimapaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
