import { Routes } from '@angular/router';
import { InscriptionUserComponent } from './inscription-user/inscription-user.component';
import { InscriptionCorpComponent } from './inscription-corp/inscription-corp.component';
import { ConnexionUserComponent } from './connexion-user/connexion-user.component';
import { HomeComponent } from './home/home.component';
import { ChoixComponent } from './choix/choix.component';
import { MyAccountComponent } from './my-account/my-account.component';

export const routes: Routes = [
    { path: 'inscription-corp', component: InscriptionCorpComponent },
    { path: 'inscription-user', component: InscriptionUserComponent },
    { path: 'connexion-user', component: ConnexionUserComponent },
    { path: '', component: HomeComponent },
    { path: 'choix', component: ChoixComponent },
    { path: 'account', component: MyAccountComponent },
];

