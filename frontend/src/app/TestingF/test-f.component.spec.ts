import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestFComponent } from './test-f.component';

describe('TestFComponent', () => {
  let component: TestFComponent;
  let fixture: ComponentFixture<TestFComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TestFComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TestFComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
