import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-dummie',
  templateUrl: './dummie.component.html',
  styleUrls: ['./dummie.component.css']
})
export class DummieComponent implements OnInit {

  profileForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],
    email: ['', Validators.email],
    password: ['', Validators.minLength(6)],
  });
  
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }

}
