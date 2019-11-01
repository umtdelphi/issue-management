import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/services/shared/project.service';
import { Page } from 'src/app/common/page';
import { Project } from 'src/app/common/project.model';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

 // projectMessage = 'from project message : owner of the license of the project is Ümit Karakaş...';

  page = new Page();
  rows = [];
  cols =[
    {prop:'id',name :'Proje No' } ,
    {prop:'projectName',name:'Proje ismi' } , 
    {prop:'projectCode',name:'Proje Kodu' } 
  ]
   
  constructor(private projectService : ProjectService) {
   

   }

  ngOnInit() {
    this.setPage({offset : 0 }) ;

    /*     this.projectService.getAll().subscribe(
          (resp) => { console.log(resp); }
        ) */
  }

  setPage(pageInfo) {
      this.page.page = pageInfo.offset;
      this.projectService.getAll(this.page).subscribe(pagedData => {
        this.page.size = pagedData.size;
        this.page.page=pagedData.page;
        this.page.totalElements=pagedData.totalElements;
        this.page.totalPages=pagedData.totalPages;
        this.rows = pagedData.content;
      });
  }
}
