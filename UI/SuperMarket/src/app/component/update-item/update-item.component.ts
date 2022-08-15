import { Component, OnInit } from '@angular/core';
import {Post} from "../../Model/post";
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../../service/post.service";

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {
  id!: string;
  data: Post = {
    id: '',
    name: '',
    quantity: 0,
    costPrice: 0,
    salePrice: 0,
  };

  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.data.id = this.route.snapshot.params['id'];
    console.log(this.data.id);
    if (!(this.data.id === '') || !(this.data.id === undefined)) {
      this.postService.getData(this.data.id).subscribe({
        next: (response: any) => {
          this.data = response;
        },
      });
    }
    else {
      this.router.navigate(["/data"]);
    }
  }
  updateData(){
    this.postService.update(this.data).subscribe({

      next: (response: any) => {
        console.log(response);
        this.router.navigate(['/data']);
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

}
