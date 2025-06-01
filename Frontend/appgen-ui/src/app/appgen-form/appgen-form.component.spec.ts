import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppgenFormComponent } from './appgen-form.component';

describe('AppgenFormComponent', () => {
  let component: AppgenFormComponent;
  let fixture: ComponentFixture<AppgenFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppgenFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppgenFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
