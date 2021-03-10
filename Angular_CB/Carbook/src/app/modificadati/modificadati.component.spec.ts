import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificadatiComponent } from './modificadati.component';

describe('ModificadatiComponent', () => {
  let component: ModificadatiComponent;
  let fixture: ComponentFixture<ModificadatiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModificadatiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModificadatiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
