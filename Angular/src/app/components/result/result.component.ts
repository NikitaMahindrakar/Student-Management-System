import { Component } from '@angular/core';
import { MarkServiceService } from 'src/app/services/mark-service/mark-service.service';
@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent {
  mark: any;

  constructor(private markService: MarkServiceService) { }

  ngOnInit() {
    this.getResult();
  }

  getResult() {
    this.markService.getResult().subscribe((res) => {
      console.log(res);
      this.mark = res.data
    })
  }

}
