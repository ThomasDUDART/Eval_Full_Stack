# Eval_Full_Stack

## Questions

L'équipe architecture aimerait que vous répondiez à quelques questions afin de valider vos choix techniques :


- Concernant la possibilité de modifier une image d'illustration, avez-vous fait une route dédiée au fait de remplacer la photo ou bien considérez-vous qu'il faille simplement appeler la route de suppression puis la route d'ajout ?
  Je n'ai pas fait de route, n'y de modification, pas le temps. Mais dans l'idéal une route dédiés serait mieux que d'appeller deux autre route, plus on contrôle mieux nos routes si une routes à une fonction.
  
- Concernant le stockage des images, est-il préférable de mettre d'avoir une seule table contenant tous les IDs de toutes les images (et faire une jointure systématique donc) ou bien vaut-il mieux mettre l'ID de la photo d'illustration dans la table restaurant et ne pas mettre d'ID en DB pour l'image d'illustration d'un restaurant ?
 Mieux vaut stocker les id dans la db du back, les images étant directement en accès par le front, il pourra ce débrouiller simplement en allant chercher les images correspondant à l'id dans la db, sans avoir à faire de jointure systématiquement et en étant plus performant.
  
- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner la photo systématiquement (via un lien bien sûr) ?
 Non, surout si l'image est lourde, mieux vaut la retoruner une fois et la stocker en cache chez l'utilisateur, s'il est amenée à la charger souvent.
 Pour une applis ou les images ne sont charger qu'as de très rare occasion, la passer en lien systématiquement peut suffire sans trop impacter les performances. 
  
- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner l'évaluation finale systématiquement ?
 Non ça ne sert à rien de la retourner systématiquement, sotcker cette information dans le cache ne prends pas beaucoup de place comparée à une image, il peut donc être stocker facilement dans le cache sans le surchargés.
  
- Expliquez l'implémentation que vous avez fait des tags (quelles solutions avez-vous envisagées et pourquoi avoir retenu la vôtre en particulier)
 Je ne l'ai pas implémentés pas le temps, pour gagner du temps j'aurais voulu faire un énum rattachée direcetement à mon objet dans le code (solution barbare).
 Avec le temps, ou simplement plus d'affinité avec le code et en allant plus vite, j'aurais fait une table suplémentaire dans ma bdd, avec une relation many to many avec les restaurant.
