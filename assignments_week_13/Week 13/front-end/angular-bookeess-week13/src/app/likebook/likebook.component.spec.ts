import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LikebookComponent } from './likebook.component';

describe('LikebookComponent', () => {
  let component: LikebookComponent;
  let fixture: ComponentFixture<LikebookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LikebookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LikebookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
