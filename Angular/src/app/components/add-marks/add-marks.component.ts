import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MarkServiceService } from 'src/app/services/mark-service/mark-service.service';
@Component({
  selector: 'app-add-marks',
  templateUrl: './add-marks.component.html',
  styleUrls: ['./add-marks.component.css']
})
export class AddMarksComponent  {
  validateForm: FormGroup;

  constructor(private MarkServiceService: MarkServiceService,
    private fb: FormBuilder
    ) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
      name: [null, [Validators.required]],
      rollno: [null, [Validators.required]],
      english: [null, [Validators.required]],
      hindi: [null, [Validators.required]],
      maths: [null, [Validators.required]],
      science: [null, [Validators.required]],
      social: [null, [Validators.required]]
    })
  }

  addMark() {
    this.MarkServiceService.addMark(this.validateForm.value).subscribe((res) => {
      console.log(res);
    })
    alert("Marks added successfully");
  }
  

}

