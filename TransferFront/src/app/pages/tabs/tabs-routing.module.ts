import { Company } from 'src/app/models/company';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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
  imports:
    [
      RouterModule.forChild(routes)
    ],
  exports:
    [
      RouterModule
    ]
})
export class TabsPageRoutingModule {}