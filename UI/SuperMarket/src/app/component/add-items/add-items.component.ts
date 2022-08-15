import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/Model/post';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-add-items',
  templateUrl: './add-items.component.html',
  styleUrls: ['./add-items.component.css']
})
export class AddItemsComponent implements OnInit {
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

  }
  AddData() {
      this.postService.save(this.data).subscribe({
        next: (response: any) => {
          console.log(response);
          this.router.navigate(['/data']).then(r => console.log(r));
        },
      });
    }

}
