import urllib.request


def main():
    for x in range(1000):
        print(f'{x}')
        if x == 0:
            continue
        try:
            response = urllib.request.urlopen(f'https://api.entropianexus.com/mobs/{x}')
        except:
            continue
        file = open(f'../../../data/mob/mob_{x}.json', 'w')
        file.write(response.read().decode("utf-8"))
        file.close()


if __name__ == "__main__":
    main()
