import React from "react";
import { GameSearchInfoVM } from "../../api/api";
import Carousel from "../../components/Carousel/Carousel";
import GameTile from "../../components/Tile/GameTile";
import { loadSimilarGames } from "../../fetchData/fetchGames";
import withLoading from "../../fetchData/withLoading";

function SimilarGames({ games }: { games: GameSearchInfoVM }) {
  return (
    <Carousel>
      {Array(10)
        .fill(games)
        .flat()
        .map((a, idx) => (
          <GameTile
            key={idx}
            game={a}
            src="https://allegro.stati.pl/AllegroIMG/PRODUCENCI/Bethesda/Fallout%204/GOTY/f2.jpg"
          />
        ))}
    </Carousel>
  );
}
export default withLoading(SimilarGames, {
  games: async (fetchId: number) => loadSimilarGames(fetchId),
});
