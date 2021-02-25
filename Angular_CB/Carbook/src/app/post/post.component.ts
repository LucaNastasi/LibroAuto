import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { PostModel } from '../model/post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.less']
})
export class PostComponent implements OnInit {

  @Input()
  public post: PostModel;

  constructor() { }

  ngOnInit(): void {
  }

}