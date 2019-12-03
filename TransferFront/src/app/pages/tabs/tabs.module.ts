import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { TabsPageRoutingModule } from './tabs-routing.module';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children:
      [
        {
          path: 'tab1',
          loadChildren: '/Users/anjulog/Documents/TransferFront/src/app/pages/company/company.module#CompanyPageModule'
          
        },
        {
          path: 'tab2',
          loadChildren: '/Users/anjulog/Documents/TransferFront/src/app/pages/company/company.module#CompanyPageModule'
        },
        {
          path: 'tab3',
          loadChildren: '/Users/anjulog/Documents/TransferFront/src/app/pages/company/company.module#CompanyPageModule'
        },
        {
          path: '',
          redirectTo: '/tabs/tab1',
          pathMatch: 'full'
        }
      ]
  },
  {
    path: '',
    redirectTo: '/tabs/tab1',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabsPageRoutingModule,
    RouterModule.forChild(routes)
  ],
  declarations: [TabsPage]
})
export class TabsPageModule {
  debugger;
}
