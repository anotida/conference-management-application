package za.co.coders23.enums;

public enum SessionType {
    MORNING {
        @Override
        public int getDuration() {
            return 3 * 60;
        }

        @Override
        public int getStartTime() {
            return 9;
        }
    },
    AFTERNOON {
        @Override
        public int getDuration() {
            return 4 * 60;
        }

        @Override
        public int getStartTime() {
            return 13;
        }
    },
    LUNCH {
        @Override
        public int getDuration() {
            return 60;
        }

        @Override
        public int getStartTime() {
            return 12;
        }
    },
    EVENT {
        @Override
        public int getDuration() {
            return 0;
        }

        @Override
        public int getStartTime() {
            return 17;
        }
    };

    public abstract int getDuration();
    public abstract int getStartTime();
}
