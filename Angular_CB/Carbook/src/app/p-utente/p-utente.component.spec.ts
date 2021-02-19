import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PUtenteComponent } from './p-utente.component';

describe('PUtenteComponent', () => {
  let component: PUtenteComponent;
  let fixture: ComponentFixture<PUtenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PUtenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PUtenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
